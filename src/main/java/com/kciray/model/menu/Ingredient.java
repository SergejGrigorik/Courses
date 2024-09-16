package com.kciray.model.menu;

import com.kciray.model.BaseEntity;
import com.kciray.model.order.BasketIngredientDish;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Ingredient implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double weigth;
    private BigDecimal price;




}
