package com.kciray.dao;

import com.kciray.database.CityDabase;
import com.kciray.database.DataBase;
import com.kciray.entity.address.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityDao extends AbstractDao<City>{
    @Autowired
    public CityDao(CityDabase db) {
        super(db);
    }
}
