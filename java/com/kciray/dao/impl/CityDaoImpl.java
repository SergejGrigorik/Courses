package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.CityDao;
import com.kciray.database.CityDabase;
import com.kciray.entity.address.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityDaoImpl extends AbstractDao<City> implements CityDao {
    @Autowired
    public CityDaoImpl(CityDabase db) {
        super(db);
    }
}
