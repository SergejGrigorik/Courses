package com.kciray.service;

import com.kciray.dto.CourierDto;
import com.kciray.model.Courier;
import com.kciray.model.DeliveryStand;
import com.kciray.model.status.CourierStatus;

import java.util.List;
import java.util.Optional;

public interface CourierService extends BaseService<Integer, CourierDto> {

    List<CourierDto> findAllByCourierStatus(CourierStatus courierStatus);

    Optional<Courier> getFreeCourier(DeliveryStand deliveryStand) ;

}