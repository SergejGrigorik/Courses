package com.kciray.dto;

import com.kciray.entity.Role;
import com.kciray.entity.User;
import com.kciray.entity.status.CourierStatus;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourierDto {

    private String locationCoordinates;
    private CourierStatus courierStatus;
//    private UserDto user;

}
