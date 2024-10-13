package com.kciray.service.order;

import com.kciray.model.order.Basket;
import com.kciray.model.order.Order;

public interface OrderService {
    Order getOrder(String promoCode);
    Basket getBasket();

}
