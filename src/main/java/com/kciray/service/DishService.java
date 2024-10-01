package com.kciray.service;

import com.kciray.dto.DishDto;
import com.kciray.dto.entityfilter.DishFilter;
import com.kciray.model.menu.Dish;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DishService extends BaseService<Integer, DishDto>{
    List<DishDto> findAllBy(Pageable pageable);

    List<DishDto> findAllByFilter(DishFilter dishFilter);

    List<DishDto> findAllByRestaurantId(Integer restaurantId);

    List<DishDto>  findAllDishByRestaurantIdAndCategoryById(Integer restId, Integer catId);

}
