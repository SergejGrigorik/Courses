package com.kciray.entity.menu;

import com.kciray.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ingredient implements BaseEntity<Integer> {
    private Integer id;
    private String name;
    private double weigth;
    private BigDecimal price;

}
