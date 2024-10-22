package com.kciray.repository;

import com.kciray.model.Coupon;
import com.kciray.model.status.Validity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    @EntityGraph(attributePaths = {"restaurant"})
    Coupon findByPromoCodeAndRestaurantId(String promoCode, Integer restaurantId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Coupon c set c.validity = :coupon " +
           "where c.id = :id")
    void updateValidity(Validity coupon, Integer id);
}
