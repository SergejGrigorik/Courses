package org.springframework.factory;

import org.springframework.annotation.autowired.annotation.Autowired;
import org.springframework.beanpostprocessorinterface.BeanPostProcessor;
import org.springframework.exception.ParameterIsPrimitiveException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ObjectFactory {

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
    private final ApplicationContext applicationContext;

    public ObjectFactory(ApplicationContext applicationContext){
        for (Class<? extends BeanPostProcessor> aClass : applicationContext.getPackagesReaderWithReflection().getReflectionsSpring().getSubTypesOf(BeanPostProcessor.class)) {
            try {
                beanPostProcessors.add(aClass.getDeclaredConstructor().newInstance());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        this.applicationContext = applicationContext;
    }

    public <T> T createObject(Class<? extends T> implClass)  {
        T t = create(implClass);
        configure(t);
        return t;
    }

    private <T> void configure(T t) {
        beanPostProcessors.forEach(objectConfigurator -> {
            try {
                objectConfigurator.configure(t, applicationContext);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
    }

    private <T> T create(Class<T> implClass)  {
        Set<Constructor<?>> constructors = Arrays.stream(implClass.getDeclaredConstructors()).filter(constructor -> constructor.isAnnotationPresent(Autowired.class)).collect(Collectors.toSet());
        if (constructors.size() == 1) {
            Constructor<?> constructor = constructors.iterator().next();
            return createObgectWithConstructorAutowired(constructor);
        }
        if (constructors.size() > 1) {
            throw new RuntimeException(String.format( "%s must have exactly one constructor",implClass.getName()).formatted(implClass.getName()));
        }
        try {
            return implClass.getDeclaredConstructor().newInstance();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    private <T> T createObgectWithConstructorAutowired(Constructor<?> constructor) {
        List<Object> objectList = new ArrayList<>();
            for (Class<?> parameter : constructor.getParameterTypes()) {
                if (parameter.isPrimitive()) {
                    throw new ParameterIsPrimitiveException (String.format("Сonstructor has primitive: %s",parameter.getName().formatted(parameter.getName())));
                } else {
                    Object object = applicationContext.getObject(parameter);
                    objectList.add(object);
                }
            }
        try {
            return (T) constructor.newInstance(objectList.toArray());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}

