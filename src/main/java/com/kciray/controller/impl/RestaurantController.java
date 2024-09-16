package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.RestaurantDto;
import com.kciray.service.BaseService;
import com.kciray.service.impl.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RestaurantController extends Controllers<RestaurantDto> implements ControllerInterfaceRun {
    @Autowired
    public RestaurantController(BaseService<Integer,RestaurantDto> services) {
        super(services);
    }

    @Override
    public void crudDemo() {

    }
}
