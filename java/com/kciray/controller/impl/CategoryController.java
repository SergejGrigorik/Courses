package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.CategoryDto;
import com.kciray.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController extends Controllers<CategoryDto> implements ControllerInterfaceRun {

    @Autowired
    public CategoryController(CategoryServiceImpl services) {
        super(services);
    }

    @Override
    public void crudDemo() {
        create(CategoryDto.builder()
                .id(21)
                .name("Burgers")
                .build());
        create(CategoryDto.builder()
                .id(22)
                .name("Pizza")
                .build());
        CategoryDto categoryDto = findById(22);
        categoryDto.setName("Drinks");
        update(22, categoryDto);
        findById(22);
        deleteById(21);

    }
}
