package com.kciray.dto.order;

import com.kciray.dto.menu.DishDto;
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
