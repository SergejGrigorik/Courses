package com.kciray.dao;

import com.kciray.database.IngredientDataBase;
import com.kciray.entity.menu.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientDao extends AbstractDao<Ingredient> {
    @Autowired
    public IngredientDao(IngredientDataBase ingredientDataBase) {
        super(ingredientDataBase);
    }
}
