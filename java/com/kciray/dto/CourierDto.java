package com.kciray.dto;

import com.kciray.model.status.CourierStatus;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourierDto {
    private int id;
    private String locationCoordinates;
    private CourierStatus courierStatus;
    private UserDto user;

}
