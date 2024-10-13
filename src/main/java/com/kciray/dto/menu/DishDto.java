package com.kciray.dto.menu;

import com.kciray.dto.CategoryDto;
import com.kciray.dto.RestaurantDto;
import com.kciray.model.status.StatusAvailability;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishDto {
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private CategoryDto category;

    @NotNull
    private RestaurantDto restaurant;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Double weight;

    private PfccDto pfcc;

    private String description;

    @NotNull
    private StatusAvailability availability;

}
