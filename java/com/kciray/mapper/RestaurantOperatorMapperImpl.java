package com.kciray.mapper;

import com.kciray.dto.RestaurantOperatorDto;
import com.kciray.entity.RestaurantOperator;
import com.kciray.mapper.interfaceMapper.RestaurantOperatorMapper;

public class RestaurantOperatorMapperImpl implements RestaurantOperatorMapper<RestaurantOperator, RestaurantOperatorDto> {
    @Override
    public RestaurantOperatorDto map(RestaurantOperator object) {
        return new RestaurantOperatorDto(
                object.getUser().getPassword(),
                object.getUser().getLogin(),
                object.getUser().getRole()
        );
    }
}
