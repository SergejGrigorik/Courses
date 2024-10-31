package com.kciray.repository.order.impl;

import com.kciray.model.Delivery;
import com.kciray.repository.order.DeliveryUpdateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeliveryUpdateRepositoryImpl implements DeliveryUpdateRepository {
    @PersistenceContext
    private final EntityManager em;

    @Override
    public Delivery update(Integer id, Delivery entity) {
        return em.merge(entity);
    }
}
