package com.kciray.repository.impl;

import com.kciray.repository.IngredientRepository;
import com.kciray.model.menu.Ingredient;
import com.kciray.repository.RepositoryBase;

@org.springframework.stereotype.Repository
public class IngredientRepositoryImpl extends RepositoryBase<Integer,Ingredient> implements IngredientRepository {

    public IngredientRepositoryImpl() {
        super(Ingredient.class);
    }
}
