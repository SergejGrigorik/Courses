package com.kciray;

import com.kciray.connection.ConnectionPool;
import com.kciray.configuration.ApplicationConfiguration;
import com.kciray.controller.impl.PfccController;
import com.kciray.controller.impl.UserController;
import com.kciray.dto.ProfileDto;
import com.kciray.dto.UserDto;
import com.kciray.entity.Role;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        ConnectionPool connectionPool = context.getBean(ConnectionPool.class);

        try {

            PfccController pfccController = context.getBean(PfccController.class);

            pfccController.findById(1);

            UserController userController = context.getBean(UserController.class);
            userController.findById(2);
            userController.deleteById(8);
            userController.create(UserDto.builder()
                            .id(8)
                            .profile(ProfileDto.builder()
                                    .id(7)
                                    .build())
                            .password("2222")
                            .login("senla")
                            .role(Role.builder()
                                    .id(2)
                                    .build())
                    .build());
            userController.update(8,UserDto.builder()
                    .id(8)
                    .profile(ProfileDto.builder()
                            .id(7)
                            .build())
                    .password("4444")
                    .login("senla!!!!!!!!!")
                    .role(Role.builder()
                            .id(2)
                            .build())
                    .build());
            ConnectionPool bean2 = context.getBean(ConnectionPool.class);


            new Thread((Runnable) () -> {
                userController.findById(2);
                pfccController.findById(1);

                pfccController.findById(1);
            }).start();
            new Thread((Runnable) () -> {
                userController.findById(2);
                pfccController.findById(1);
            }).start();
            new Thread((Runnable) () -> {
                userController.findById(2);
                pfccController.findById(1);
            }).start();
        } finally {
            connectionPool.closePool();
        }

    }
}

