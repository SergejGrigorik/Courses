package com.kciray.dto;

import com.kciray.model.Restaurant;
import com.kciray.model.User;
import com.kciray.model.status.StatusFullness;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasketDto {
    private Integer id;
    private RestaurantDto restaurant;
    private UserDto user;
//    private StatusFullness statusFullness;
}
