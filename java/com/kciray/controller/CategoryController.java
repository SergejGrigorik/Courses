package com.kciray.controller;

import com.kciray.dto.CategoryDto;
import com.kciray.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController extends Controllers<CategoryDto> implements ControllerInterfaceRun {
    @Autowired
    CategoryService categoryService;

    public CategoryController(CategoryService services) {
        super(services);
    }

    @Override
    public void crud() {
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
