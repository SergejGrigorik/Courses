package com.kciray.database;

import com.kciray.entity.RestaurantOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestaurantOperatorDataBase implements DataBase<Integer, RestaurantOperator> {

    private static RestaurantOperatorDataBase restaurantOperatorDataBase;
    private Map<Integer, RestaurantOperator> restaurantOperatorDataBaseMap = new HashMap<>();
    @Autowired
    private GenerationId<RestaurantOperator> generationId;

    private RestaurantOperatorDataBase() {
    }

    public static RestaurantOperatorDataBase getInstance() {
        if (restaurantOperatorDataBase == null) {
            restaurantOperatorDataBase = new RestaurantOperatorDataBase();
        }
        return restaurantOperatorDataBase;
    }


    @Override
    public Map<Integer, RestaurantOperator> getMapDataBase() {
        return restaurantOperatorDataBaseMap;
    }

    @Override
    public RestaurantOperator getEntityFromDataBase(RestaurantOperator value) {
        return generationId.addEntityDataBase(value, restaurantOperatorDataBaseMap);
    }
}
