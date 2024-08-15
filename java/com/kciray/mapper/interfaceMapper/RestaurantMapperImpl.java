package com.kciray.mapper.interfaceMapper;

import com.kciray.dto.RestaurantDto;
import com.kciray.entity.Restaurant;

public class RestaurantMapperImpl implements RestaurantMapper<Restaurant, RestaurantDto> {
    @Override
    public RestaurantDto map(Restaurant object) {
        return new RestaurantDto(
                object.getAccountBank(),
                object.getLocationCoordinates()
        );
    }
}
