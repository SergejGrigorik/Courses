package com.kciray.model.menu;

import com.kciray.model.BaseEntity;
import com.kciray.model.Restaurant;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"pfcc", "restaurant", "category"})
@EqualsAndHashCode(exclude = {"pfcc", "restaurant", "category"})
@Data
@Builder
@Entity
public class Dish implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;


    private BigDecimal price;

    private Double weight;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pfcc_id", nullable = false)
    private Pfcc pfcc;

    private String description;

    private Integer discount;


}
