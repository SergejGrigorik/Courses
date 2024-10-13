package com.kciray.repository.impl;


import com.kciray.model.address.Region;
import com.kciray.repository.RegionRepository;
import com.kciray.repository.RepositoryBase;

@org.springframework.stereotype.Repository
public class RegionRepositoryImpl extends RepositoryBase<Integer, Region> implements RegionRepository {

    public RegionRepositoryImpl() {
        super(Region.class);
    }

}

