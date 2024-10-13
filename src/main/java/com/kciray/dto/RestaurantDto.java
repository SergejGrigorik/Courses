package com.kciray.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RestaurantDto {

    private Integer id;

    @NotNull
    private Integer accountBank;

    @NotNull
    private String locationCoordinates;
}
