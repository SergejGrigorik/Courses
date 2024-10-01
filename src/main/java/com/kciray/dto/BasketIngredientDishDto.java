package com.kciray.dto;


import com.kciray.model.order.BasketItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasketIngredientDishDto {
    private Integer id;
    private BasketItem basketItem;
    private Integer countIngredients;
}
