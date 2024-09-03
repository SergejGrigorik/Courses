package com.kciray.bbp;

import com.kciray.connection.ConnectionPool;
import com.kciray.annotation.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class TransactionBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Class<?>> beanHasClassTransaction = new HashMap<>();
    private final Map<String, Class<?>> beanHasMethodTransaction = new HashMap<>();
    private Map<String, Set<Method>> mapMethodsHasAnnotation = new HashMap<>();
    private Set<Method> setMethodsHasAnnotations;


    @Autowired
    private ConnectionPool connectionPool;


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        setMethodsHasAnnotations = new HashSet<>();

        if (bean.getClass().isAnnotationPresent(Transaction.class)) {
            beanHasClassTransaction.put(beanName, bean.getClass());
        }
        if (beanHasClassTransaction.isEmpty()) {
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Transaction.class)) {
                    beanHasMethodTransaction.put(beanName, bean.getClass());
                    setMethodsHasAnnotations.add(method);
                }
            }
            mapMethodsHasAnnotation.put(beanName, setMethodsHasAnnotations);
        }


        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {

        Class<?> transClass = beanHasClassTransaction.get(beanName);
        if (transClass != null) {
            return Proxy.newProxyInstance(transClass.getClassLoader(), transClass.getInterfaces(),

                    (proxy, method, args) -> {
                        Connection connection = connectionPool.getConnectionForThread().get();
                        try {
                            connection = connectionPool.getConnectionForThread().get();
                            connection.setAutoCommit(false);
                            return method.invoke(bean, args);
                        } catch (RuntimeException e) {
                            if (connection != null) {
                                connection.rollback();
                            }
                            throw e;
                        } finally {
                            if (connection != null) {
                                connection.commit();
                            }
                        }
                    });
        }

        Class<?> transMethod = beanHasMethodTransaction.get(beanName);
        if (transMethod != null) {
            return Proxy.newProxyInstance(transMethod.getClassLoader(), transMethod.getInterfaces(),
                    (proxy, method, args) -> {
                        Method methodInvokeWithAnnotation = mapMethodsHasAnnotation.entrySet().stream()
                                .filter(k -> k.getKey().equals(beanName))
                                .map(value -> value.getValue()
                                        .stream()
                                        .filter(method1 -> method.getName().equals(method1.getName()))
                                        .findAny().get())
                                .findAny().get();

                        if (!(methodInvokeWithAnnotation == null)) {
                            Connection connection = connectionPool.getConnectionForThread().get();
                            try {
                                connection = connectionPool.getConnectionForThread().get();
                                connection.setAutoCommit(false);
                                return method.invoke(bean, args);
                            } catch (RuntimeException e) {
                                if (connection != null) {
                                    connection.rollback();
                                }
                                throw e;
                            } finally {
                                if (connectionPool.isValidateConnection()) {
                                    connection.commit();
                                }
                            }
                        }

                        return method.invoke(bean, args);
                    });
        }
        return bean;
    }
}