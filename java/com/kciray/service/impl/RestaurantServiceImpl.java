package com.kciray.service.impl;

import com.kciray.dao.impl.RestaurantDaoImpl;
import com.kciray.dto.RestaurantDto;
import com.kciray.entity.Restaurant;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl extends AbstractService<Restaurant,RestaurantDto> implements BaseService<Integer, RestaurantDto> , RestaurantService {

    @Autowired
    public RestaurantServiceImpl(RestaurantDaoImpl categoryDao) {
        super(Restaurant.class, RestaurantDto.class, categoryDao);
    }

}

















