package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.Dao;
import com.kciray.dao.DishDao;
import com.kciray.database.DishDataBase;
import com.kciray.entity.menu.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DishDaoImpl implements DishDao, Dao<Integer,Dish> {


    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Dish save(Dish ticket) {
        return null;
    }

    @Override
    public void update(Dish ticket) {

    }

    @Override
    public Optional<Dish> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Dish> findAll() {
        return List.of();
    }
}
