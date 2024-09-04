package com.kciray.dao.impl;


import com.kciray.dao.Dao;
import com.kciray.dao.RestaurantChainDao;
import com.kciray.database.RestaurantChainDataBase;
import com.kciray.entity.RestaurantChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantChainDaoImpl implements RestaurantChainDao, Dao<Integer, RestaurantChain> {



    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public RestaurantChain save(RestaurantChain ticket) {
        return null;
    }

    @Override
    public void update(RestaurantChain ticket) {

    }

    @Override
    public Optional<RestaurantChain> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<RestaurantChain> findAll() {
        return List.of();
    }
}
