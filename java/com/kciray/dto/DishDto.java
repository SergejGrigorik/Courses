package com.kciray.dto;

import com.kciray.entity.Restaurant;
import com.kciray.entity.menu.Category;
import com.kciray.entity.menu.Pfcc;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class DishDto {
    private int id;
    private String name;
    private CategoryDto category;
    private RestaurantDto restaurant;
    private BigDecimal price;
    private double weight;
    private PfccDto pfcc;
    private String description;
    private int discount;

}
