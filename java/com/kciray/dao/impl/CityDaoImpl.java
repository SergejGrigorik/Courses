package com.kciray.dao.impl;


import com.kciray.dao.AbstractDao;
import com.kciray.dao.CityDao;
import com.kciray.dao.Dao;
import com.kciray.database.CityDabase;
import com.kciray.entity.address.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class CityDaoImpl  implements CityDao, Dao<Integer,City> {
    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public City save(City ticket) {
        return null;
    }

    @Override
    public void update(City ticket) {

    }

    @Override
    public Optional<City> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<City> findAll() {
        return List.of();
    }
}
