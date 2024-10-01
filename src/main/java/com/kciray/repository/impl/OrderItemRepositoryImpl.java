package com.kciray.repository.impl;

import com.kciray.model.order.OrderItem;
import com.kciray.repository.OrderItemRepository;
import com.kciray.repository.RepositoryBase;

public class OrderItemRepositoryImpl extends RepositoryBase<Integer, OrderItem> implements OrderItemRepository {

    public OrderItemRepositoryImpl(){
        super(OrderItem.class);
    }
}
