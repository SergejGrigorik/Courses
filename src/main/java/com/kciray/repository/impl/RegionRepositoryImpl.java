package com.kciray.repository.impl;

import com.kciray.model.address.Region;
import com.kciray.repository.RegionRepository;
import com.kciray.repository.RepositoryBase;
import org.springframework.stereotype.Repository;

@Repository
public class RegionRepositoryImpl extends RepositoryBase<Integer, Region> implements RegionRepository {

    public RegionRepositoryImpl() {
        super(Region.class);
    }

}

