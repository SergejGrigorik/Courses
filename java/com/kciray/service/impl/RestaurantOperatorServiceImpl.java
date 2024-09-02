package com.kciray.service.impl;


import com.kciray.dao.impl.RestaurantOperatorDaoImpl;
import com.kciray.dto.RestaurantOperatorDto;
import com.kciray.entity.RestaurantOperator;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.RestaurantOperatorService;
import com.kciray.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RestaurantOperatorServiceImpl extends AbstractService< Integer,RestaurantOperator,RestaurantOperatorDto> implements BaseService<Integer,RestaurantOperatorDto>,
        RestaurantOperatorService {

    @Autowired
    public RestaurantOperatorServiceImpl(RestaurantOperatorDaoImpl restaurantOperatorDao) {
        super(RestaurantOperator.class, RestaurantOperatorDto.class, restaurantOperatorDao);
    }

}
