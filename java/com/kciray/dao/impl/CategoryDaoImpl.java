package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.CategoryDao;
import com.kciray.database.CategoryDataBase;

import com.kciray.entity.menu.Category;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao {
    @Autowired
    public CategoryDaoImpl(CategoryDataBase categoryDataBase) {
        super(categoryDataBase);
    }
}
