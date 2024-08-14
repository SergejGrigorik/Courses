package com.kciray.dao;

import com.kciray.database.RestaurantDataBase;
import com.kciray.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDao extends AbstractDao< Restaurant> {
    @Autowired
    public RestaurantDao(RestaurantDataBase restaurantDataBase) {
        super(restaurantDataBase);
    }
}
