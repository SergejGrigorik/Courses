package com.kciray.dto;

import com.kciray.model.Coupon;
import com.kciray.model.User;
import com.kciray.model.status.StatusOrder;
import com.kciray.model.status.StatusPayment;

public class OrderDto {
    private Integer id;
    private User user;
    private Coupon coupon;
    private Integer promoCode;
    private StatusOrder statusOrder;
    private StatusPayment statusPayment;


}
