package com.kciray.service;

import com.kciray.model.ScheduleCourierForDay;
import com.kciray.model.status.StatusBusyCourier;

import java.time.LocalTime;
import java.util.List;

public interface ScheduleCourierForDayService {

    List<ScheduleCourierForDay> findByTimeFromAndTimeToAndDayAndStatusHas(LocalTime deliveryTime, String dayOfWeekFromDate, String statusHasInQueue);

    void updateStatus(Integer id, StatusBusyCourier statusBusyCourier);
}
