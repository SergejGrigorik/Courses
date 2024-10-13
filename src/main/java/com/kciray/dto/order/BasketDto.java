package com.kciray.dto.order;

import com.kciray.dto.RestaurantDto;
import com.kciray.dto.UserDto;
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
}
