package com.kciray.database;

import com.kciray.entity.menu.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;



public class IngredientDataBase  implements DataBase<Integer,Ingredient>{
    private static IngredientDataBase ingredientDataBase;
    private Map<Integer, Ingredient> ingredientDataBaseMap = new HashMap<>();
    private GenerationId<Ingredient> generationId;

    private IngredientDataBase() {
    }

    public static IngredientDataBase getInstance() {
        if (ingredientDataBase == null) {
            ingredientDataBase = new IngredientDataBase();
        }
        return ingredientDataBase;
    }



    @Override
    public Map<Integer, Ingredient> getMapDataBase() {
        return ingredientDataBaseMap;
    }

    @Override
    public Ingredient getEntityFromDataBase(Ingredient value) {
        return generationId.addEntityDataBase(value,ingredientDataBaseMap);
    }

}
