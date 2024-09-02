package com.kciray.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScheduleRestaurant {
    private int id;
    private Restaurant restaurant;
    private String workingHoursFrom;
    private String workingHoursTo;
    private Day day;

}
