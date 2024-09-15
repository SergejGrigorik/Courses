package com.kciray.service.impl;


import com.kciray.repository.impl.CategoryRepositoryImpl;
import com.kciray.dto.CategoryDto;
import com.kciray.model.menu.Category;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl
        extends AbstractService<Integer,Category, CategoryDto> implements BaseService<Integer, CategoryDto>, CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryRepositoryImpl categoryDao) {
        super(Category.class, CategoryDto.class, categoryDao);

    }


}
