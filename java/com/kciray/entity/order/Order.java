package com.kciray.entity.order;

import com.kciray.entity.Coupon;
import com.kciray.entity.User;
import com.kciray.entity.status.StatusOrder;
import com.kciray.entity.status.StatusPayment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Order {
    private int id;
    private User user;
    private BigDecimal sumPrice;
    private Coupon coupon;
    private String couponCode;
    private StatusOrder statusOrder;
    private StatusPayment statusPayment;
}
