package com.kciray.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "restaurant_chain")
public class RestaurantChain implements BaseEntity<Integer> {

    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "restaurantChain", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Restaurant> restaurant = new ArrayList<>();
}
