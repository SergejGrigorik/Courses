package com.kciray.entity.order;

import com.kciray.entity.menu.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IngredientDish {
    private int id;
    private OrderItem orderItem;
    private Ingredient ingredient;
    private int countIngredient;
    private BigDecimal priceSum;
}
