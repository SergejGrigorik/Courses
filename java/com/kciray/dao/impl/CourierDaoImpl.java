package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.CourierDao;
import com.kciray.dao.Dao;
import com.kciray.database.CourierDataBase;
import com.kciray.entity.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourierDaoImpl implements CourierDao, Dao<Integer,Courier> {

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Courier save(Courier ticket) {
        return null;
    }

    @Override
    public void update(Courier ticket) {

    }

    @Override
    public Optional<Courier> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Courier> findAll() {
        return List.of();
    }
}

