package com.kciray;

import com.kciray.configuration.ApplicationConfiguration;
import com.kciray.controller.CategoryController;
import com.kciray.controller.CourierController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        CategoryController bean = context.getBean(CategoryController.class);
        bean.crud();
        CourierController bean2 = context.getBean(CourierController.class);
        bean2.crud();


    }
}

