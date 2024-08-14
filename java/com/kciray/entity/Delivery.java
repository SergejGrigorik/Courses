package com.kciray.entity;

import com.kciray.entity.address.Address;
import com.kciray.entity.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Delivery {
    private int id;
    private Order order;
    private Courier courier;
    private LocalDateTime deliveryTimeFrom;
    private LocalDateTime deliveryTimeTo;
    private String locationCoordinatesUser;
    private Address deliveryAddress;
    private Restaurant restaurant;
}
