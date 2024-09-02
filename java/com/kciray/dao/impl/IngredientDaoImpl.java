package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.IngredientDao;
import com.kciray.database.IngredientDataBase;
import com.kciray.entity.menu.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientDaoImpl extends AbstractDao<Ingredient> implements IngredientDao {
    @Autowired
    public IngredientDaoImpl(IngredientDataBase ingredientDataBase) {
        super(ingredientDataBase);
    }
}
