package com.kciray.dto.order;

import com.kciray.model.menu.Dish;
import com.kciray.model.order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderItemDto {
    private Integer id;
    private Order order;
    private Dish dish;
    private BigDecimal price;

}
