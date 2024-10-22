package com.kciray.service.order;

import com.kciray.dto.CategoryDto;
import com.kciray.dto.DeliveryDto;
import com.kciray.dto.address.AddressDto;
import com.kciray.service.BaseService;

import java.time.LocalDate;
import java.time.LocalTime;

public interface DeliveryService extends BaseService<Integer, DeliveryDto> {


    void createDelivery(LocalDate date, LocalTime time, String promoCode, AddressDto addressDto);

    void findByCourierForOrder();

}
