package com.kciray.repository.impl;


import com.kciray.model.RestaurantOperator;
import com.kciray.model.address.Address;
import com.kciray.model.address.Region;
import com.kciray.model.menu.Dish;
import com.kciray.repository.RegionDao;
import com.kciray.repository.RepositoryBase;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;

@org.springframework.stereotype.Repository
public class RegionRepositoryImpl extends RepositoryBase<Integer, Region> implements RegionDao {
//    @PersistenceContext
//    private EntityManager entityManager;


    public RegionRepositoryImpl() {
        super(Region.class);
    }



}

