package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.*;
import com.kciray.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller

public class CourierController extends Controllers<CourierDto> implements ControllerInterfaceRun {
@Autowired

    public CourierController(BaseService<Integer,CourierDto> courierService) {
        super(courierService);
    }


    @Override
    public void crudDemo() {

    }
}
