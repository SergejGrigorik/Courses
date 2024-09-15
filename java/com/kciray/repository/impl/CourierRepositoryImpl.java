package com.kciray.repository.impl;

import com.kciray.repository.CourierDao;
import com.kciray.model.Courier;
import com.kciray.repository.RepositoryBase;

@org.springframework.stereotype.Repository
public class CourierRepositoryImpl extends RepositoryBase<Integer,Courier> implements CourierDao {


    public CourierRepositoryImpl() {
        super(Courier.class);
    }
}

