package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.IngredientDto;
import com.kciray.service.impl.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class IngredientController extends Controllers<IngredientDto> implements ControllerInterfaceRun {
    @Autowired
    public IngredientController(IngredientServiceImpl services) {
        super(services);
    }

    @Override
    public void crudDemo() {
        create(IngredientDto.builder()
                .id(1)
                .name("Cheese")
                .weigth(123.2)
                .price(BigDecimal.valueOf(1000))
                .build());

        create(IngredientDto.builder()
                .id(2)
                .name("Bakon")
                .weigth(239.2)
                .price(BigDecimal.valueOf(340))
                .build());
        IngredientDto ingredientDto = findById(1);
        ingredientDto.setName("mushroom");
        update(1,ingredientDto);
        findById(1);
        deleteById(1);




    }
}
