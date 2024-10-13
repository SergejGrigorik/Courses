package com.kciray.service.impl;

import com.kciray.repository.RestaurantRepository;
import com.kciray.dto.RestaurantDto;
import com.kciray.model.Restaurant;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl extends AbstractService<Integer,Restaurant,RestaurantDto> implements RestaurantService{

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        super(Restaurant.class, RestaurantDto.class, restaurantRepository);
    }

}

















