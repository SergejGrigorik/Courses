package com.kciray.repository.impl;

import com.kciray.model.order.Order;
import com.kciray.repository.RepositoryBase;
import com.kciray.service.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImp extends RepositoryBase<Integer, Order> implements OrderRepository {

    public OrderRepositoryImp(){
        super(Order.class);
    }




}
