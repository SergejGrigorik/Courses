package com.kciray.entity.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasketIngredientDish {
    private int id;
    private BasketItem basketItem;
    private int countIngredients;
    private BigDecimal priceAmount;
}
