package com.kciray.model.order;

import com.kciray.model.Coupon;
import com.kciray.model.User;
import com.kciray.model.status.StatusOrder;
import com.kciray.model.status.StatusPayment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "booking")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_user_id")
    private User user;

    @Column(name = "sum_price")
    private BigDecimal sumPrice;

    @JoinColumn(name = "coupon_id")
    @OneToOne
    private Coupon coupon;



    @Column(name = "promo_code")
    private Integer promoCode;

    @Column(name = "status_booking_id")
    private StatusOrder statusOrder;

    @Column(name = "status_payment")
    @Enumerated(value = EnumType.STRING)
    private StatusPayment statusPayment;
    // change table type

    @Builder.Default
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

}
