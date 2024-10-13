package com.kciray.dto;

import com.kciray.model.status.CourierStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CourierDto {
    private Integer id;
    private CourierStatus courierStatus;
    private UserDto user;

}
