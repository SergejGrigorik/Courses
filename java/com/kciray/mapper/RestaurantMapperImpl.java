package com.kciray.mapper;

import com.kciray.dto.RestaurantDto;
import com.kciray.entity.Restaurant;
import com.kciray.mapper.interfaceMapper.RestaurantMapper;

public class RestaurantMapperImpl implements RestaurantMapper<Restaurant, RestaurantDto> {
    @Override
    public RestaurantDto map(Restaurant object) {
        return new RestaurantDto(
                object.getAccountBank(),
                object.getLocationCoordinates()
        );
    }
}
