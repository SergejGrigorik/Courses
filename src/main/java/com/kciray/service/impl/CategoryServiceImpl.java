package com.kciray.service.impl;

import com.kciray.dto.CategoryDto;
import com.kciray.model.menu.Category;
import com.kciray.repository.CategoryRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl
        extends AbstractService<Integer, Category, CategoryDto> implements CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super(Category.class, CategoryDto.class, categoryRepository);

    }


}
