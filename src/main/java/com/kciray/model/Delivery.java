package com.kciray.model;

import com.kciray.model.address.Address;
import com.kciray.model.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @Column(name = "delivery_time_from")
    private LocalDateTime deliveryTimeFrom;

    @Column(name = "delivery_time_to")
    private LocalDateTime deliveryTimeTo;

    @Column(name = "location_coordinates_user")
    private String locationCoordinatesUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id_user")
    private Address deliveryAddress;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
