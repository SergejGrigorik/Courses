package com.kciray.service.basket;

import com.kciray.dto.menu.DishDto;
import com.kciray.model.menu.Dish;

public interface BasketService {

    Dish addDish(DishDto dto);
    void deleteById(Integer id);
}
