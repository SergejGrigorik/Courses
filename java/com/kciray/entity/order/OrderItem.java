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
public class OrderItem {
    private int id;
    private Order order;
    private Dish dish;
    private BigDecimal price;
}
