package com.kciray.dto;

import com.kciray.model.menu.Dish;
import com.kciray.model.order.Basket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasketItemDto {
    private Integer id;
    private BasketDto basket;
    private DishDto dish;
    private BigDecimal price;

}
