package com.kciray.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RestaurantOperator implements BaseEntity<Integer> {
    private Integer id;
    private Restaurant restaurant;
    private User user;
}
