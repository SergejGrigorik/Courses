package com.kciray.repository;

import com.kciray.dto.entityfilter.DishFilter;
import com.kciray.model.menu.Dish;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DishRepository extends ApplicationRepository<Integer, Dish> {
    List<Dish> findAllDishByRestaurantIdAndCategoryById(Integer restaurantId, Integer categoryId);

    List<Dish> findAllBy(Pageable pageable);

    List<Dish> findAllByFilter(DishFilter dishFilter);

}
