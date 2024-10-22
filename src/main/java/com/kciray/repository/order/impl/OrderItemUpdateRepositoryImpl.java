package com.kciray.repository.order.impl;

import com.kciray.dto.order.OrderItemDto;
import com.kciray.repository.order.OrderItemUpdateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderItemUpdateRepositoryImpl implements OrderItemUpdateRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public OrderItemDto update(Integer id, OrderItemDto entity) {
        return entityManager.merge(entity);
    }
}
