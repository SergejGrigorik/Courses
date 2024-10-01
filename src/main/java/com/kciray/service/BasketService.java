package com.kciray.service;

import com.kciray.dto.BasketDto;
import com.kciray.dto.DishDto;
import com.kciray.model.menu.Dish;

public interface BasketService extends BaseService<Integer, BasketDto> {
    Dish addDish(DishDto dto);

//    List<Basket> findAll();

//    Optional<Basket> findById(Integer id);


//    Optional<Basket> update(Integer id, Basket basket);

//    boolean deleteById(Integer id);

//    Optional<Basket> update(Integer id, Basket basketController);
}
