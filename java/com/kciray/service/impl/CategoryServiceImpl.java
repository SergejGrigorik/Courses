package com.kciray.service.impl;


import com.kciray.dao.impl.CategoryDaoImpl;
import com.kciray.dto.CategoryDto;
import com.kciray.entity.menu.Category;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CategoryServiceImpl
        extends AbstractService<Integer,Category, CategoryDto> implements BaseService<Integer, CategoryDto>, CategoryService {

    @Autowired
    public CategoryServiceImpl(CategoryDaoImpl categoryDao) {
        super(Category.class, CategoryDto.class, categoryDao);

    }


}
