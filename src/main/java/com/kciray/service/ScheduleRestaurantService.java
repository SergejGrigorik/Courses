package com.kciray.service;

import com.kciray.model.ScheduleRestaurant;

public interface ScheduleRestaurantService {
    ScheduleRestaurant findByRestaurantId(Integer restaurantId , String day);
}
