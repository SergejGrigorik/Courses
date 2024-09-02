package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.CourierDao;
import com.kciray.database.CourierDataBase;
import com.kciray.entity.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourierDaoImpl extends AbstractDao<Courier> implements CourierDao {
@Autowired
    public CourierDaoImpl(CourierDataBase db) {
        super(db);
    }
}

