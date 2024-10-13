package com.kciray.repository.basket;

import com.kciray.model.order.Basket;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    @EntityGraph(attributePaths = {"listBasketItem", "listBasketItem.basket"})
    Optional<Basket> findByUserId(Integer userId);
}
