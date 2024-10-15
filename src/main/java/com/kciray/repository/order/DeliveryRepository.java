package com.kciray.repository.order;

import com.kciray.model.Courier;
import com.kciray.model.Delivery;
import com.kciray.model.status.StatusLookCourier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    Optional<Delivery> findByOrderId(Integer orderId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Delivery d set d.courier = :courier, d.lookCourier = :statusLookCourier where d.id = :id")
    void update(Integer id, Courier courier,StatusLookCourier statusLookCourier);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Delivery d set d.lookCourier = :statusLookCourier where d.id = :id")
    void updateStatus(Integer id, StatusLookCourier statusLookCourier);
}
