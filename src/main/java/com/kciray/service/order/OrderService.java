package com.kciray.service.order;

import com.kciray.dto.order.OrderDto;
import com.kciray.model.order.Basket;
import com.kciray.model.order.Order;

import java.util.List;

public interface OrderService {
    Order getOrder(String promoCode);

    Basket getBasket();

    OrderDto findById(Integer id);

    List<OrderDto> findAll();

    void deleteById(Integer id);


}
