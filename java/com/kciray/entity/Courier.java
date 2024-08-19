package com.kciray.entity;

import com.kciray.entity.status.CourierStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Courier implements BaseEntity<Integer> {
    private Integer id;
    private String locationCoordinates;
    private CourierStatus courierStatus;
    private User user;

}