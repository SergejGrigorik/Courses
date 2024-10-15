package com.kciray.model;

import com.kciray.model.address.Address;
import com.kciray.model.status.StatusLookCourier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "delivery_stand")
public class DeliveryStand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery ;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "start_delivery")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "look_courier")
    private StatusLookCourier lookCourier;

}
