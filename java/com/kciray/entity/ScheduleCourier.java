package com.kciray.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScheduleCourier {
    private int id;
    private Courier courier;
    private String workingHoursFrom;
    private String workingHoursTo;
    private Day day;

}
