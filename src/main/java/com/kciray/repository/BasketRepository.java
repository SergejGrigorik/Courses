package com.kciray.repository;

import com.kciray.model.order.Basket;

import com.kciray.model.order.BasketItem;

import java.util.Optional;

public interface BasketRepository extends ApplicationRepository<Integer,Basket>{
    void addDish();

    void addIngredient();

    Basket saveBasket(Basket build);

    BasketItem saveBasketItem(BasketItem build);

    Optional<Basket> findByUserId(Integer id);
}
