package org.springframework.scanner;

import org.reflections.Reflections;
import org.springframework.annotation.component.Component;
import org.springframework.exception.DuplicateException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PackagesReaderWithReflection {
    private final Reflections scannerAnnotationComponent;
    private final Map<Class<?>, Class<?>> interf2Impl = new HashMap<>();
    private final Reflections scannerSpringFramework = new Reflections("org.springframework");
    private Set<Class<?>> classes;

    public PackagesReaderWithReflection(String packageToScan) {
        this.scannerAnnotationComponent = new Reflections(packageToScan);
        createClassesWithAnnotationComponent();
        createClassesWithInterf();
    }

    public Reflections getReflectionsSpring() {
        return scannerSpringFramework;
    }

    public void createClassesWithAnnotationComponent() {
        classes = scannerAnnotationComponent.getTypesAnnotatedWith(Component.class);
//        scannerAnnotationComponent.getSubTypesOf(Object.class);
    }

    private void createClassesWithInterf() {
        for (Class<?> clazz : classes) {
            Class<?>[] interfaces = clazz.getInterfaces();
            for (Class<?> interf : interfaces) {
                change(interf);
                interf2Impl.put(interf, clazz);
            }
        }
    }

    private void change(Class<?> interf) {
        if (interf2Impl.containsKey(interf)) {
           throw  new DuplicateException(String.format("Duplicate class found: %s",interf.getName()).formatted(interf.getName()));
        }
    }

    public <T> Class<? extends T> getInterf2Impl(Class<T> type) {
        return (Class<? extends T>) interf2Impl.get(type);
    }
}
