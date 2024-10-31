package com.kciray.repository;

import com.kciray.model.ScheduleCourierForDay;
import com.kciray.model.status.StatusBusyCourier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;

public interface ScheduleCourierForDayRepository extends JpaRepository<ScheduleCourierForDay, Integer> {

    @Query(value = "select * from schedule_courier_for_day s where working_hours_from < :deliveryTime and working_hours_to > :deliveryTime and day = :day and busy = :status", nativeQuery = true)
    List<ScheduleCourierForDay> findByTimeFromAndTimeToAndDayAndStatusHas(LocalTime deliveryTime, String day, String status);

    ScheduleCourierForDay saveAndFlush(ScheduleCourierForDay scheduleCourierForDay);


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update ScheduleCourierForDay s set s.statusBusyCourier = :status where s.id = :id")
    void updateStatus(Integer id, StatusBusyCourier status);
}
