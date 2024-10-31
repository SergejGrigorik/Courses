package com.kciray.repository;

import com.kciray.model.Courier;
import com.kciray.model.DeliveryStand;
import com.kciray.model.status.StatusLookCourier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DeliveryStandRepository extends JpaRepository<DeliveryStand, Integer> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update DeliveryStand d set d.courier = :freeCourier, d.lookCourier = :statusLookCourier " +
           "where d.id = :id")
    void update(Integer id, Courier freeCourier, StatusLookCourier statusLookCourier);

    DeliveryStand saveAndFlush(DeliveryStand deliveryStand);

    Optional<DeliveryStand> findById(Integer id);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update DeliveryStand d set d.lookCourier = :statusLookCourier " +
           "where d.id = :id")
    void updateStatus(Integer id, StatusLookCourier statusLookCourier);
}


