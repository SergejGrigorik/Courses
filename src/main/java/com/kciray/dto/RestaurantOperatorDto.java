package com.kciray.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RestaurantOperatorDto  {
    private Integer id;

    @NotNull
    private RestaurantDto restaurant;

    @NotNull
    private UserDto user;
}
