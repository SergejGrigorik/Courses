package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.IngredientDto;
import com.kciray.service.BaseService;
import com.kciray.service.impl.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class IngredientController extends Controllers<IngredientDto> implements ControllerInterfaceRun {
    @Autowired
    public IngredientController(BaseService<Integer,IngredientDto> services) {
        super(services);
    }

    @Override
    public void crudDemo() {
    }
}
