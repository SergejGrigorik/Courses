package com.kciray.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RestaurantOperatorDto  {
    private Integer id;
    private RestaurantDto restaurant;
    private UserDto user;
}
