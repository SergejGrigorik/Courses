package com.kciray.service.basket;

import com.kciray.model.order.BasketItem;

public interface BasketItemService {

    void deleteAll();

    BasketItem save(BasketItem build);
}
