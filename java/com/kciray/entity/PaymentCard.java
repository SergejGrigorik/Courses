package com.kciray.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentCard {
    private int id;
    private String cardHolder;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
}
