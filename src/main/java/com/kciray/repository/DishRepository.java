package com.kciray.repository;

import com.kciray.model.menu.Dish;

import java.util.List;

public interface DishRepository extends Repository<Integer, Dish> {
    List<Dish> findAllDishByRestaurantIdAndCategoryById(Integer restaurantId, Integer categoryId);
}
