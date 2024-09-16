package com.kciray.repository;

import com.kciray.model.Restaurant;

public interface RestaurantRepository extends Repository<Integer, Restaurant> {
    Restaurant findAddressAndRestaurantById(Integer id);
}
