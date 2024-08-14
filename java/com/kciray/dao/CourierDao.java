package com.kciray.dao;

import com.kciray.database.CourierDataBase;
import com.kciray.database.DataBase;
import com.kciray.entity.Courier;
import com.kciray.entity.menu.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class CourierDao extends AbstractDao<Courier>{
@Autowired
    public CourierDao(CourierDataBase db) {
        super(db);
    }
}

