package com.kciray.dao;

import com.kciray.database.DishDataBase;
import com.kciray.entity.menu.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DishDao extends AbstractDao<Dish> {

    @Autowired
    public DishDao(DishDataBase dishDataBase) {
        super(dishDataBase);
    }
}
