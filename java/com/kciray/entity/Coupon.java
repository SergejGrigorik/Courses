package com.kciray.entity;

import com.kciray.entity.status.Validity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Coupon {
    private int id;
    private Restaurant restaurant;
    private String promoCode;
    private Validity validity;
    private int discount;
}
