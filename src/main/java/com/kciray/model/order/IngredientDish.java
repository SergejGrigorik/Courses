package com.kciray.model.order;

import com.kciray.model.menu.Ingredient;
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
@Table(name = "ingredient_dish")
public class IngredientDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @JoinColumn(name = "booking_item_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrderItem orderItem;


    @JoinColumn(name = "ingredients_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;


    @Column(name = "count_ingredient")
    private Integer countIngredient;

    @Column(name = "price_amount")
    private BigDecimal priceSum;
}
