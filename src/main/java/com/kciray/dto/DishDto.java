package com.kciray.dto;

import lombok.*;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishDto {
    private Integer id;
    private String name;
    private CategoryDto category;
    private RestaurantDto restaurant;
    private BigDecimal price;
    private Double weight;
    private PfccDto pfcc;
    private String description;
    private Integer discount;

}
