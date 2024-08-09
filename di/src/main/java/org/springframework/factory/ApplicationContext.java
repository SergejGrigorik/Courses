package org.springframework.factory;

import org.springframework.scanner.PackagesReaderWithReflection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    private final PackagesReaderWithReflection packagesReader;
    private ObjectFactory objectFactory;
    private final Map<Class<?>, Object> beanFactory = new ConcurrentHashMap<>();

    public ApplicationContext(PackagesReaderWithReflection packagesReader)  {
        this.packagesReader = packagesReader;
    }

    public <T> T getObject(Class<T> type) {
        if (beanFactory.containsKey(type)) {

            return (T) beanFactory.get(type);
        }
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = packagesReader.getInterf2Impl(type);
        }
        T t = null;
            t = objectFactory.createObject(implClass);
        beanFactory.put(type, t);
        return t;
    }

    public PackagesReaderWithReflection getPackagesReaderWithReflection() {
        return packagesReader;
    }

    public void setObjectFactory(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }
}
