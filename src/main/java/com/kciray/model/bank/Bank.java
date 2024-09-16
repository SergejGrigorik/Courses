package com.kciray.model.bank;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "account_restaurant")
    private Integer accountRestaurant;
    @Column(name = "cardholder_id")
    private String cardHolder;
    @Column(name = "number_card_id")
    private Integer numberCard;
    @Column(name = "payment_amount")
    private Integer paymentAmount;
    @Column(name = "balance_restaurant_before_payment")
    private BigDecimal balanceRestaurantBeforePayment;
    @Column(name = "balance_restaurant_after_payment")
    private BigDecimal balanceRestaurantAfterPayment;
//    в таблицах инт
}
