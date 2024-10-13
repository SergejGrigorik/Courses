package com.kciray.service.order;

import com.kciray.model.order.Basket;
import com.kciray.model.order.Order;
import com.kciray.model.order.OrderItem;

import java.util.List;

public interface OrderItemService {

    List<OrderItem> createOrderItems(Order order, Basket basket);
}
