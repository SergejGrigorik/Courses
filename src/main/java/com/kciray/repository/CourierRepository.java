package com.kciray.repository;

import com.kciray.model.Courier;
import com.kciray.model.status.CourierStatus;

import java.util.List;

public interface CourierRepository extends ApplicationRepository<Integer, Courier> {
    List<Courier> findAllByCourierStatus(CourierStatus courierStatus);
}
