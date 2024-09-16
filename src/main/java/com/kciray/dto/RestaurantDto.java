package com.kciray.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RestaurantDto {
    private Integer accountBank;
    private String locationCoordinates;
}
