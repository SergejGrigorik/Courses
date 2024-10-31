package com.kciray.repository.order;

import com.kciray.dto.order.OrderItemDto;

public interface OrderItemUpdateRepository {
    OrderItemDto update(Integer id, OrderItemDto entity);
}
