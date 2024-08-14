package com.kciray.dto;

import com.kciray.entity.Role;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RestaurantOperatorDto  {
    private int password;
    private String login;
    private Role role;

}
