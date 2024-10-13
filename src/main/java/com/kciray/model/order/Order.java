package com.kciray.model.order;

import com.kciray.model.BaseEntity;
import com.kciray.model.Coupon;
import com.kciray.model.User;
import com.kciray.model.status.StatusOrder;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = {"user","coupon","statusOrder","orderItems"})
@EqualsAndHashCode(exclude = {"user","coupon","statusOrder","orderItems"})
@Entity
@Table(name = "booking")
public class Order implements BaseEntity<Integer> {

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
    private String promoCode;

    @Column(name = "status_order_id")
    private StatusOrder statusOrder;

    @Builder.Default
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

}
