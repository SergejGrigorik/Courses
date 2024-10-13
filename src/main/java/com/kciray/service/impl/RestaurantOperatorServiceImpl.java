package com.kciray.service.impl;

import com.kciray.dto.RestaurantOperatorDto;
import com.kciray.model.RestaurantOperator;
import com.kciray.repository.RestaurantOperatorRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.RestaurantOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantOperatorServiceImpl extends AbstractService<Integer, RestaurantOperator, RestaurantOperatorDto> implements RestaurantOperatorService {

    @Autowired
    public RestaurantOperatorServiceImpl(RestaurantOperatorRepository restaurantOperatorRepository) {
        super(RestaurantOperator.class, RestaurantOperatorDto.class, restaurantOperatorRepository);
    }

}
