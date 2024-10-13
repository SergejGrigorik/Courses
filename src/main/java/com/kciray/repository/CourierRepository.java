package com.kciray.repository;

import com.kciray.dto.CourierDto;
import com.kciray.model.Courier;
import com.kciray.model.User;
import com.kciray.model.status.CourierStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourierRepository extends JpaRepository<Courier, Integer> {

    @Query(value = "select count(c) from Courier c")
    long count();

    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query("update  Courier c set c.courierStatus = :courierStatus, c.user = :user where c.id = :id" )
    Courier update(Integer id, User user, CourierStatus courierStatus);
}
