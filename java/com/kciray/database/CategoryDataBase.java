package com.kciray.database;

import com.kciray.entity.menu.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


public class CategoryDataBase implements DataBase<Integer, Category> {
    private static CategoryDataBase instance;
    Map<Integer, Category> categoryMap = new HashMap<>();

    private GenerationId<Category> generationId;


    private CategoryDataBase() {
    }

    public static CategoryDataBase getInstance() {
        if (instance == null) {
            instance = new CategoryDataBase();
        }
        return instance;
    }

    @Override
    public Map<Integer, Category> getMapDataBase() {
        return categoryMap;
    }

    @Override
    public Category getEntityFromDataBase(Category category) {
        return generationId.addEntityDataBase(category, categoryMap);
    }

}
