package com.kciray.database;

import com.kciray.entity.Courier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;




public class CourierDataBase implements DataBase<Integer, Courier> {
    private static CourierDataBase courierDataBase;
    private Map<Integer, Courier> courierDataBaseMap = new HashMap<>();


    private GenerationId<Courier> generationId;

    private CourierDataBase() {
    }

    public static CourierDataBase getInstance() {
        if (courierDataBase == null) {
            courierDataBase = new CourierDataBase();
        }
        return courierDataBase;
    }


    @Override
    public Map<Integer, Courier> getMapDataBase() {
        return courierDataBaseMap;
    }

    @Override
    public Courier getEntityFromDataBase(Courier courier) {
        return generationId.addEntityDataBase(courier, courierDataBaseMap);
    }
}
