package org.springframework.annotation.autowired;

import org.springframework.annotation.autowired.annotation.Autowired;
import org.springframework.beanpostprocessorinterface.BeanPostProcessor;
import org.springframework.factory.ApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class AutowiredBeanPostProcessor implements BeanPostProcessor {

    @Override
    public void configure(Object bean, ApplicationContext context)  {
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                try {
                    field.set(bean, object);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                field.setAccessible(false);
            }
        }
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Autowired.class)) {
                method.setAccessible(true);
                List<Object> args = Arrays.asList(method.getParameterTypes());
                if (args.size() != 1) {
                    throw  new RuntimeException(String.format("%s must have exactly one argument",method.getName()).formatted(method.getName()));
                }
                Object object = context.getObject(Arrays.stream(method.getParameterTypes()).iterator().next());
                try {
                    method.invoke(bean, object);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
                method.setAccessible(false);
            }
        }
    }
}
