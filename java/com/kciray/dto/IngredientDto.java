package com.kciray.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientDto {
    private int id;
    private String name;
    private double weigth;
    private BigDecimal price;
}
