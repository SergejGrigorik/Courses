package com.kciray.repository.order;

import com.kciray.model.Delivery;

public interface DeliveryUpdateRepository {
    Delivery update(Integer id, Delivery entity);
}
