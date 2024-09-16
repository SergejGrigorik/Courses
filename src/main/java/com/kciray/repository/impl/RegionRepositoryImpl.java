package com.kciray.repository.impl;


import com.kciray.model.address.Region;
import com.kciray.repository.RegionRepository;
import com.kciray.repository.RepositoryBase;

@org.springframework.stereotype.Repository
public class RegionRepositoryImpl extends RepositoryBase<Integer, Region> implements RegionRepository {
//    @PersistenceContext
//    private EntityManager entityManager;


    public RegionRepositoryImpl() {
        super(Region.class);
    }



}

