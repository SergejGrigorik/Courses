package com.kciray.database;

import com.kciray.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestaurantDataBase implements DataBase<Integer, Restaurant> {
    private static RestaurantDataBase restaurantDataBase;

    private Map<Integer, Restaurant> restaurantDataBaseDataBaseMap = new HashMap<>();

    @Autowired
    private GenerationId<Restaurant> generationId;

    private RestaurantDataBase() {
    }

    public static RestaurantDataBase getInstance() {
        if (restaurantDataBase == null) {
            restaurantDataBase = new RestaurantDataBase();
        }
        return restaurantDataBase;
    }


    @Override
    public Map<Integer, Restaurant> getMapDataBase() {
        return restaurantDataBaseDataBaseMap;
    }

    @Override
    public Restaurant getEntityFromDataBase(Restaurant value) {
        return generationId.addEntityDataBase(value, restaurantDataBaseDataBaseMap);
    }
}
