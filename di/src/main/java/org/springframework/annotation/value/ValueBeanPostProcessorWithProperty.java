package org.springframework.annotation.value;

import org.springframework.annotation.value.interfaces.Value;
import org.springframework.beanpostprocessorinterface.BeanPostProcessor;
import org.springframework.factory.ApplicationContext;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ValueBeanPostProcessorWithProperty implements BeanPostProcessor {

    private final Map<String, String> valuesFromPropertiesFile = new HashMap<>();

    public ValueBeanPostProcessorWithProperty() {
        createCashValue();
    }

    private void createCashValue() {
        Properties properties = new Properties();
        String path = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("application.properties")).getPath();
        try {
            properties.load(new FileReader(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String key : properties.stringPropertyNames())
            valuesFromPropertiesFile.put(key, properties.getProperty(key));
    }

    @Override
    public void configure(Object bean, ApplicationContext context){
        Class<?> implClass = bean.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            Value annotation = field.getAnnotation(Value.class);
            if (annotation != null) {
                field.setAccessible(true);
                try {
                    field.set(bean, valuesFromPropertiesFile.get(annotation.name()));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

