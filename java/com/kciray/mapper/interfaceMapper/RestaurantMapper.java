package com.kciray.mapper.interfaceMapper;

public interface RestaurantMapper<F,T> {
    T map(F object);
}
