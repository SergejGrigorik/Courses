package com.kciray.model;

import com.kciray.model.status.Validity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(exclude = {"restaurant"})
@ToString(exclude = {"restaurant"})
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "promo_code")
    private String promoCode;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "validity")
    private Validity validity;

    private Integer discount;
}
