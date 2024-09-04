package com.kciray.dao.impl;


import com.kciray.dao.Dao;
import com.kciray.dao.RestaurantDao;
import com.kciray.database.RestaurantDataBase;
import com.kciray.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantDaoImpl  implements RestaurantDao, Dao<Integer,Restaurant> {

    public RestaurantDaoImpl() {

    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Restaurant save(Restaurant ticket) {
        return null;
    }

    @Override
    public void update(Restaurant ticket) {

    }

    @Override
    public Optional<Restaurant> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Restaurant> findAll() {
        return List.of();
    }
}
