package com.kciray.repository.impl;


import com.kciray.repository.RepositoryBase;
import com.kciray.repository.RestaurantChainRepository;
import com.kciray.model.RestaurantChain;

@org.springframework.stereotype.Repository
public class RestaurantChainRepositoryImpl  extends RepositoryBase<Integer, RestaurantChain> implements RestaurantChainRepository {


    public RestaurantChainRepositoryImpl() {
        super(RestaurantChain.class);
    }



}
