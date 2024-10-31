package com.kciray.service.impl;

import com.kciray.model.ScheduleCourier;
import com.kciray.model.ScheduleCourierForDay;
import com.kciray.model.status.StatusBusyCourier;
import com.kciray.repository.ScheduleCourierForDayRepository;
import com.kciray.service.ScheduleCourierForDayService;
import com.kciray.service.ScheduleCourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleCourierForDayServiceImpl implements ScheduleCourierForDayService {

    private final ScheduleCourierForDayRepository scheduleCourierForDayRepository;
    private final ScheduleCourierService scheduleCourierService;
    private List<ScheduleCourier> scheduleCouriers;
    private LocalTime workingHoursTo;
    private LocalTime workingHoursFrom;

    public void createScheduleForDay() {
        findAllCourier();
    }

    @Scheduled(cron = "${scheduled.cron.time.createScheduleForDay}", timeUnit = TimeUnit.MINUTES)
    public void findAllCourier() {
        scheduleCouriers = scheduleCourierService.findAll();
        for (ScheduleCourier scheduleCourier1 : scheduleCouriers) {
            createScheduleTime(scheduleCourier1);
        }

    }

    public void createScheduleTime(ScheduleCourier scheduleCourier) {
        scheduleCourierForDayRepository.deleteAll();
        workingHoursTo = scheduleCourier.getWorkingHoursTo();
        workingHoursFrom = scheduleCourier.getWorkingHoursFrom();
        while (workingHoursFrom.isBefore(workingHoursTo)) {
            LocalTime localTime = workingHoursFrom.plusMinutes(40);
            ScheduleCourierForDay build = ScheduleCourierForDay.builder()
                    .courier(scheduleCourier.getCourier())
                    .scheduleCourier(scheduleCourier)
                    .workingHoursFrom(workingHoursFrom)
                    .workingHoursTo(localTime)
                    .day(scheduleCourier.getDay().name())
                    .statusBusyCourier(StatusBusyCourier.FREE)
                    .build();
            scheduleCourierForDayRepository.saveAndFlush(build);
            workingHoursFrom = workingHoursFrom.plusMinutes(40);
            System.out.println(workingHoursFrom);

        }

    }

    public List<ScheduleCourierForDay> findByTimeFromAndTimeToAndDayAndStatusHas(LocalTime deliveryTime, String dayOfWeekFromDate, String status) {
        return scheduleCourierForDayRepository.findByTimeFromAndTimeToAndDayAndStatusHas(deliveryTime, dayOfWeekFromDate, status);
    }

    @Override
    public void updateStatus(Integer id, StatusBusyCourier status) {
        scheduleCourierForDayRepository.updateStatus(id, status);
    }
}
