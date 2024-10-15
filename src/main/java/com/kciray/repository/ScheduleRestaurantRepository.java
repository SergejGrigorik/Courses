package com.kciray.repository;

import com.kciray.model.ScheduleRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleRestaurantRepository extends JpaRepository<ScheduleRestaurant,Integer> {

    @Query(value = "select * from schedule_restaurant where day_of_week = :day and restaurant_id = :restaurantId",nativeQuery = true)
    ScheduleRestaurant findByRestaurantId(Integer restaurantId , String day);
}
