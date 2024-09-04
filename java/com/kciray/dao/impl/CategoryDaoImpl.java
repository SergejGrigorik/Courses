package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.CategoryDao;
import com.kciray.dao.Dao;
import com.kciray.database.CategoryDataBase;

import com.kciray.entity.menu.Category;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class CategoryDaoImpl  implements CategoryDao, Dao<Integer,Category> {


    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Category save(Category ticket) {
        return null;
    }

    @Override
    public void update(Category ticket) {

    }

    @Override
    public Optional<Category> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }
}
