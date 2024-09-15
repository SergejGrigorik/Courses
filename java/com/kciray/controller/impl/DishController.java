package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.CategoryDto;
import com.kciray.dto.DishDto;
import com.kciray.dto.PfccDto;
import com.kciray.dto.RestaurantDto;
import com.kciray.service.BaseService;
import com.kciray.service.impl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class DishController extends Controllers<DishDto>  {

@Autowired
    public DishController(BaseService<Integer,DishDto> services) {
        super(services);
    }

}
