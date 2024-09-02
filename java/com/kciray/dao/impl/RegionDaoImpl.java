package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.RegionDao;
import com.kciray.database.RegionDataBase;
import com.kciray.entity.address.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegionDaoImpl extends AbstractDao<Region> implements RegionDao {
    @Autowired
    public RegionDaoImpl(RegionDataBase db) {

        super(db);
    }
}

