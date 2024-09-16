package com.kciray;


import com.kciray.configuration.ApplicationConfiguration;
import com.kciray.repository.impl.RestaurantRepositoryImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

    }

}
