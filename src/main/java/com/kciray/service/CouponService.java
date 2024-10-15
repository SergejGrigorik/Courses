package com.kciray.service;

import com.kciray.dto.CouponDto;
import com.kciray.model.Coupon;
import com.kciray.model.status.Validity;

public interface CouponService {

    Coupon findByPromoCodeAndRestaurantId(String promoCode, Integer restaurantId);

    CouponDto create(CouponDto couponDto);

    boolean deleteById(Integer id);

    void updateValidity(Validity coupon, Integer id);
}
