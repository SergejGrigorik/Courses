package com.kciray.entity.bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bank {
    private int id;
    private int accountRestaurant;
    private String cardHolder;
    private int numberCard;
    private int paymentAmount;
    private BigDecimal balanceRestaurantBeforePayment;
    private BigDecimal balanceRestaurantAfterPayment;
//    в таблицах инт
}
