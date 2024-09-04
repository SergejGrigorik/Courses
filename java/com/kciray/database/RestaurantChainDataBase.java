package com.kciray.database;

import com.kciray.entity.RestaurantChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;



public class RestaurantChainDataBase  implements DataBase<Integer, RestaurantChain>{

    private static RestaurantChainDataBase restaurantChainDataBase;
    Map<Integer, RestaurantChain> restaurantDataBaseMap = new HashMap<>();

    private GenerationId<RestaurantChain> generationId;

    private RestaurantChainDataBase(){
    }

    public static RestaurantChainDataBase getInstance() {
        if (restaurantChainDataBase == null) {
            restaurantChainDataBase = new RestaurantChainDataBase();
        }
        return restaurantChainDataBase;
    }


    @Override
    public Map<Integer, RestaurantChain> getMapDataBase() {
        return restaurantDataBaseMap;
    }

    @Override
    public RestaurantChain getEntityFromDataBase(RestaurantChain value) {
        return generationId.addEntityDataBase(value,restaurantDataBaseMap);

    }
}
