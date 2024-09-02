package com.kciray.dao.impl;


import com.kciray.dao.Dao;
import com.kciray.dao.RegionDao;
import com.kciray.database.RegionDataBase;
import com.kciray.entity.address.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RegionDaoImpl  implements RegionDao , Dao<Integer,Region> {

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Region save(Region ticket) {
        return null;
    }

    @Override
    public void update(Region ticket) {

    }

    @Override
    public Optional<Region> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Region> findAll() {
        return List.of();
    }
}

