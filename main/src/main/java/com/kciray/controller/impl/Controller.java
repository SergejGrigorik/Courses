package com.kciray.controller.impl;

import com.kciray.service.ServiceInterface;
import org.springframework.annotation.autowired.annotation.Autowired;
import org.springframework.annotation.component.Component;

@Component
public class Controller {

    private ServiceInterface serviceInterface;

    @Autowired
    public Controller(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public ServiceInterface getServiceInterface() {
        return serviceInterface;
    }


    public void execute() {
        serviceInterface.execute();
    }
}
