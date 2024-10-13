package com.kciray.model;

import com.kciray.model.address.Address;
import com.kciray.model.order.Order;
import com.kciray.model.status.StatusLookCourier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

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

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "delivery_time")
    private LocalTime deliveryTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id_user")
    private Address deliveryAddress;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    @Column(name = "look_courier")
    private StatusLookCourier lookCourier;

}
