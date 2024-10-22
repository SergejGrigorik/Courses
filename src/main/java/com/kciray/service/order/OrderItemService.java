package com.kciray.service.order;

import com.kciray.dto.order.OrderItemDto;
import com.kciray.model.order.Basket;
import com.kciray.model.order.Order;
import com.kciray.model.order.OrderItem;
import com.kciray.service.BaseService;

import java.util.List;

public interface OrderItemService extends BaseService<Integer, OrderItemDto> {
    List<OrderItem> createOrderItems(Order order, Basket basket);
}
