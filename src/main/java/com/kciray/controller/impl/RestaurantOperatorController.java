package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.*;
import com.kciray.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RestaurantOperatorController extends Controllers<RestaurantOperatorDto> implements ControllerInterfaceRun {
    @Autowired
    public RestaurantOperatorController(BaseService<Integer,RestaurantOperatorDto> services) {
        super(services);
    }

    @Override
    public void crudDemo() {

    }
}
