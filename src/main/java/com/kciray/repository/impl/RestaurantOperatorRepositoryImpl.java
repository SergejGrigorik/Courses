package com.kciray.repository.impl;

import com.kciray.model.RestaurantOperator;
import com.kciray.repository.RepositoryBase;
import com.kciray.repository.RestaurantOperatorRepository;

@org.springframework.stereotype.Repository
public class RestaurantOperatorRepositoryImpl extends RepositoryBase<Integer, RestaurantOperator> implements RestaurantOperatorRepository {

    public RestaurantOperatorRepositoryImpl() {
        super(RestaurantOperator.class);
    }

}
