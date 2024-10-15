package com.kciray.service;

import com.kciray.model.Courier;
import com.kciray.model.DeliveryStand;
import com.kciray.model.status.StatusLookCourier;

import java.util.Optional;

public interface DeliveryStandService {

    DeliveryStand saveAndFlush(DeliveryStand deliveryStand);

    Optional<DeliveryStand> findById(Integer id);

    void deleteById(Integer id);

    void update(Integer id, Courier freeCourier, StatusLookCourier statusLookCourier);

    void updateStatus(Integer id, StatusLookCourier statusLookCourier);
}
