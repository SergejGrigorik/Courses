package com.kciray.dao;

import com.kciray.database.DataBase;
import com.kciray.database.RestaurantChainDataBase;
import com.kciray.entity.RestaurantChain;

public class RestaurantChainDao extends AbstractDao<RestaurantChainDao>{

    public RestaurantChainDao(RestaurantChainDataBase db) {
        super(db);
    }
}
