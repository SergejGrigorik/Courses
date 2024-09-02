package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.Dao;
import com.kciray.dao.IngredientDao;
import com.kciray.database.IngredientDataBase;
import com.kciray.entity.menu.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IngredientDaoImpl implements IngredientDao , Dao<Integer,Ingredient> {
    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Ingredient save(Ingredient ticket) {
        return null;
    }

    @Override
    public void update(Ingredient ticket) {

    }

    @Override
    public Optional<Ingredient> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Ingredient> findAll() {
        return List.of();
    }
}
