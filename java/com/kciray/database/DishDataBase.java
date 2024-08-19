package com.kciray.database;

import com.kciray.entity.menu.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.Map;


@Component
public class DishDataBase implements DataBase<Integer, Dish> {
    private static DishDataBase dishDataBase;
    private Map<Integer, Dish> dishDataBaseMap = new HashMap<>();
    @Autowired
    private GenerationId<Dish> generationId;

    private DishDataBase() {

    }

    public static DishDataBase getInstance() {
        if (dishDataBase == null) {
            dishDataBase = new DishDataBase();
        }
        return dishDataBase;
    }


    @Override
    public Map<Integer, Dish> getMapDataBase() {
        return dishDataBaseMap;
    }

    @Override
    public Dish getEntityFromDataBase(Dish dish) {
        return generationId.addEntityDataBase(dish, dishDataBaseMap);
    }

}
