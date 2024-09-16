package com.kciray.repository.impl;


import com.kciray.model.*;
import com.kciray.repository.RepositoryBase;
import com.kciray.repository.RestaurantOperatorRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

@org.springframework.stereotype.Repository
public class RestaurantOperatorRepositoryImpl extends RepositoryBase<Integer, RestaurantOperator> implements RestaurantOperatorRepository {


    public RestaurantOperatorRepositoryImpl() {
        super(RestaurantOperator.class);
    }


}
