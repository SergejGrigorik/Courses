package com.kciray.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_card_id")
    private PaymentCard paymentCard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_user_id")
    private User user;
}
