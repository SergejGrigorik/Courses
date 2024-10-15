package com.kciray.service.impl;

import com.kciray.model.ScheduleRestaurant;
import com.kciray.repository.ScheduleRestaurantRepository;
import com.kciray.service.ScheduleRestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class ScheduleRestaurantServiceImpl implements ScheduleRestaurantService {

    private final ScheduleRestaurantRepository scheduleRestaurantRepository;

    @Override
    public ScheduleRestaurant findByRestaurantId(Integer restaurantId, String day) {
        return scheduleRestaurantRepository.findByRestaurantId(restaurantId,day);
    }
}
