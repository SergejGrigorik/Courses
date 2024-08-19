package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.RestaurantDao;
import com.kciray.database.RestaurantDataBase;
import com.kciray.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDaoImpl extends AbstractDao< Restaurant> implements RestaurantDao {
    @Autowired
    public RestaurantDaoImpl(RestaurantDataBase restaurantDataBase) {
        super(restaurantDataBase);
    }
}
