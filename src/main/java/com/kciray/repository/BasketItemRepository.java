package com.kciray.repository;

import com.kciray.model.order.BasketItem;

public interface BasketItemRepository extends ApplicationRepository<Integer, BasketItem>{
    boolean deleteAll();
}
