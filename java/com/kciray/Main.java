package com.kciray;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.kciray.configuration.ApplicationConfiguration;
import com.kciray.controller.CategoryController;
import com.kciray.dto.CategoryDto;
import com.kciray.dto.DishDto;
import com.kciray.dto.PaymentCardDto;
import com.kciray.entity.PaymentCard;
import com.kciray.entity.menu.Dish;
import com.kciray.entity.menu.Ingredient;
import com.kciray.service.CategoryService;
import com.kciray.service.DishService;
import com.kciray.service.PaymentCardService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;


public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        CategoryController bean = context.getBean(CategoryController.class);
        bean.Crud();
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new Jdk8Module());

//        CategoryService bean = context.getBean(CategoryService.class);
//        System.out.println( bean.findAll());
//        System.out.println(bean.findById(1) + "        ++++++");
//        System.out.println(bean.create(CategoryService.builder()
//                        .id(2)
//                        .name("ewfwf")
//                .build()));
//        System.out.println(bean.create(C.builder()
//                        .id(2)
//                        .name("ewfwf")
//                .build()));

//        System.out.println(bean.findAll());
//        System.out.println(bean.findById(3).get() + " -------------");
//        CategoryService d = bean.findById(3).get();
//        d.setName("eeeeeeeeEEEEEEEEEEEEEEE");
//        System.out.println(bean.update(3,d) + "-----------------");
//        System.out.println(bean.findById(3).get() + " -------------");
//        System.out.println(bean.deleteById(1));





//        DishService dishService = context.getBean(DishService.class);
//        CourierService courierService = context.getBean(CourierService.class);
//
//                System.out.println(objectMapper.writeValueAsString(dishService.findByid(3)));

//        System.out.println(dishService.findByid(2));
//        DishDao dishDao = context.getBean(DishDao.class);
//        System.out.println(dishDao.findById(2));
//        ObjectMapper objectMapper = new ObjectMapper();
//        String j = objectMapper.writeValueAsString(dishDao.findById(2));
//        System.out.println(j);


    }
}

