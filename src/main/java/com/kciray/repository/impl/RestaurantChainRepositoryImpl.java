package com.kciray.repository.impl;

import com.kciray.model.RestaurantChain;
import com.kciray.repository.RepositoryBase;
import com.kciray.repository.RestaurantChainRepository;

@org.springframework.stereotype.Repository
public class RestaurantChainRepositoryImpl extends RepositoryBase<Integer, RestaurantChain> implements RestaurantChainRepository {

    public RestaurantChainRepositoryImpl() {
        super(RestaurantChain.class);
    }
}
