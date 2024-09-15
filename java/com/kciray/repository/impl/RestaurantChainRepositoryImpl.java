package com.kciray.repository.impl;


import com.kciray.model.Restaurant;
import com.kciray.model.RestaurantOperator;
import com.kciray.model.address.Address;
import com.kciray.model.menu.Dish;
import com.kciray.repository.RepositoryBase;
import com.kciray.repository.RestaurantChainDao;
import com.kciray.model.RestaurantChain;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.util.List;

@org.springframework.stereotype.Repository
public class RestaurantChainRepositoryImpl  extends RepositoryBase<Integer, RestaurantChain> implements RestaurantChainDao {


    public RestaurantChainRepositoryImpl() {
        super(RestaurantChain.class);
    }



}
