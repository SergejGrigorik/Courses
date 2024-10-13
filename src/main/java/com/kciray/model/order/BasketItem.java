package com.kciray.model.order;

import com.kciray.model.BaseEntity;
import com.kciray.model.menu.Dish;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = {"basket", "dish",})
@EqualsAndHashCode(exclude = {"basket", "dish"})
@Entity
@Table(name = "basket_item")
public class BasketItem implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    private BigDecimal price;


}
