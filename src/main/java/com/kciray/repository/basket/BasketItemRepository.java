package com.kciray.repository.basket;

import com.kciray.model.order.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepository extends JpaRepository<BasketItem,Integer> {

     void deleteAll();
}
