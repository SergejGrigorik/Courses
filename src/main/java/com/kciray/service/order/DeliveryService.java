package com.kciray.service.order;

import com.kciray.dto.address.AddressDto;

import java.time.LocalDate;
import java.time.LocalTime;

public interface DeliveryService {


    void createDelivery(LocalDate date, LocalTime time, String promoCode, AddressDto addressDto);

    void findByCourierForOrder();

}
