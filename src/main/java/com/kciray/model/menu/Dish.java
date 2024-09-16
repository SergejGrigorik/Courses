package com.kciray.model.menu;

import com.kciray.model.BaseEntity;
import com.kciray.model.Restaurant;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
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

    @NotNull
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @NotNull
    private BigDecimal price;
    @NotNull
    private Double weight;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pfcc_id", nullable = false)
    private Pfcc pfcc;

    private String description;

    private Integer discount;


}
