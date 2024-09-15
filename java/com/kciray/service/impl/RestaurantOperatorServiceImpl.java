package com.kciray.service.impl;


import com.kciray.repository.impl.RestaurantOperatorRepositoryImpl;
import com.kciray.dto.RestaurantOperatorDto;
import com.kciray.model.RestaurantOperator;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.RestaurantOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RestaurantOperatorServiceImpl extends AbstractService< Integer,RestaurantOperator,RestaurantOperatorDto> implements BaseService<Integer,RestaurantOperatorDto>,
        RestaurantOperatorService {

    @Autowired
    public RestaurantOperatorServiceImpl(RestaurantOperatorRepositoryImpl restaurantOperatorDao) {
        super(RestaurantOperator.class, RestaurantOperatorDto.class, restaurantOperatorDao);
    }

}
