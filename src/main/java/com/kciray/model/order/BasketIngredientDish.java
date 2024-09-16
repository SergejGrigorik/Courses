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
@Table(name = "basket_ingredient_dish")
public class BasketIngredientDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_item_id")
    private BasketItem basketItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient")
    private Ingredient ingredient;

    @Column(name = "count_ingredients")
    private Integer countIngredients;

    @Column(name = "price_amount")
    private BigDecimal priceAmount;
}
