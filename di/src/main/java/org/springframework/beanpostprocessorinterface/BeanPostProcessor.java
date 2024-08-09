package org.springframework.beanpostprocessorinterface;

import org.springframework.factory.ApplicationContext;

public interface BeanPostProcessor {
    void configure(Object bean, ApplicationContext context) ;
}
