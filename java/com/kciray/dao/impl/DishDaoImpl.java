package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.DishDao;
import com.kciray.database.DishDataBase;
import com.kciray.entity.menu.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DishDaoImpl extends AbstractDao<Dish> implements DishDao {

    @Autowired
    public DishDaoImpl(DishDataBase dishDataBase) {
        super(dishDataBase);
    }
}
