package com.kciray.dao;

import com.kciray.database.RestaurantOperatorDataBase;
import com.kciray.entity.RestaurantOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantOperatorDao extends AbstractDao<RestaurantOperator> {
    @Autowired
    public RestaurantOperatorDao(RestaurantOperatorDataBase restaurantOperatorDataBase) {

        super(restaurantOperatorDataBase);
    }

}
