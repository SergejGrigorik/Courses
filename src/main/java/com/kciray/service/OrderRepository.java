package com.kciray.service;

import com.kciray.model.order.Order;
import com.kciray.repository.ApplicationRepository;

public interface OrderRepository extends ApplicationRepository<Integer, Order> {
}
