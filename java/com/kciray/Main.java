package com.kciray;

import com.kciray.configuration.ApplicationConfiguration;
import com.kciray.controller.ControllerInterfaceRun;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        Map<String, ControllerInterfaceRun> beansOfType = context.getBeansOfType(ControllerInterfaceRun.class);
        for (ControllerInterfaceRun run : beansOfType.values()) {
            run.crudDemo();
        }
    }

}

