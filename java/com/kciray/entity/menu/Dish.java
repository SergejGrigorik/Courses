package com.kciray.entity.menu;

import com.kciray.entity.BaseEntity;
import com.kciray.entity.Restaurant;
import com.kciray.entity.RestaurantChain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Dish implements BaseEntity<Integer> {
    private Integer id;
    private String name;
    private Category category;
    private Restaurant restaurant;
    private BigDecimal price;
    private double weight;
    private Pfcc pfcc;
    private String description;
    private int discount;

}
