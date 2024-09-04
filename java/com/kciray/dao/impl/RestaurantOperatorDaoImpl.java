package com.kciray.dao.impl;


import com.kciray.dao.Dao;
import com.kciray.dao.RestaurantOperatorDao;
import com.kciray.database.RestaurantOperatorDataBase;
import com.kciray.entity.RestaurantOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantOperatorDaoImpl  implements RestaurantOperatorDao, Dao<Integer,RestaurantOperator> {


    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public RestaurantOperator save(RestaurantOperator ticket) {
        return null;
    }

    @Override
    public void update(RestaurantOperator ticket) {

    }

    @Override
    public Optional<RestaurantOperator> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<RestaurantOperator> findAll() {
        return List.of();
    }
}
