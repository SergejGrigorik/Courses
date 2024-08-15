package com.kciray.dao;

import com.kciray.database.RegionDataBase;
import com.kciray.entity.address.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegionDao extends AbstractDao<Region> {
    @Autowired
    public RegionDao(RegionDataBase db) {

        super(db);
    }
}

