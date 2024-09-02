package com.kciray.database;

import com.kciray.entity.address.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CityDabase implements DataBase<Integer, City> {
    private static CityDabase instance;
    Map<Integer, City> cityDataBase = new HashMap<Integer, City>();
    @Autowired
    private GenerationId<City> generationId;

    private CityDabase() {
    }

    public static CityDabase getInstance() {
        if (instance == null) {
            instance = new CityDabase();
        }
        return instance;
    }

    @Override
    public Map<Integer, City> getMapDataBase() {
        return cityDataBase;
    }

    @Override
    public City getEntityFromDataBase(City value) {
        return generationId.addEntityDataBase(value, cityDataBase);
    }
}
