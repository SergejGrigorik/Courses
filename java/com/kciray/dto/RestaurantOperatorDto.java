package com.kciray.dto;

import com.kciray.entity.Restaurant;
import com.kciray.entity.Role;

import com.kciray.entity.User;
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
