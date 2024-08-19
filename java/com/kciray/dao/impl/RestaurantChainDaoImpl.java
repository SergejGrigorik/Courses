package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.RestaurantChainDao;
import com.kciray.database.RestaurantChainDataBase;
import com.kciray.entity.RestaurantChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantChainDaoImpl extends AbstractDao<RestaurantChain> implements RestaurantChainDao {
@Autowired
    public RestaurantChainDaoImpl(RestaurantChainDataBase db) {
        super(db);
    }
}
