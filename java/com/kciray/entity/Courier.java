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
public class Courier {
    private int id;
    private String locationCoordinates;
    private CourierStatus courierStatus;
    private User user;

}
