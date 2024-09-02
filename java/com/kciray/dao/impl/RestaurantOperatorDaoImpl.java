package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.RestaurantOperatorDao;
import com.kciray.database.RestaurantOperatorDataBase;
import com.kciray.entity.RestaurantOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantOperatorDaoImpl extends AbstractDao<RestaurantOperator> implements RestaurantOperatorDao {
    @Autowired
    public RestaurantOperatorDaoImpl(RestaurantOperatorDataBase restaurantOperatorDataBase) {

        super(restaurantOperatorDataBase);
    }

}
