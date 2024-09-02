package com.kciray.entity.order;

import com.kciray.entity.menu.Dish;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasketItem {
    private int id;
    private Basket basket;
    private Dish dish;
    private BigDecimal price;
}
