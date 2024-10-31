package com.kciray.model;

import com.kciray.model.address.Address;
import com.kciray.model.menu.Dish;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"restaurantChain", "address", "dish", "coupons", "deliveries", "restaurantOperator"})
@EqualsAndHashCode(exclude = {"restaurantChain", "address", "dish", "coupons", "deliveries", "restaurantOperator"})
@Data
@Builder
@Component
@Entity
public class Restaurant implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_chain_id")
    private RestaurantChain restaurantChain;

    @Column(name = "account_bank")
    private int accountBank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    private Long number;

    @Builder.Default
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Dish> dish = new ArrayList<Dish>();

    @Builder.Default
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Coupon> coupons = new ArrayList<Coupon>();

    @Builder.Default
    @OneToMany(mappedBy = "restaurant")
    private List<Delivery> deliveries = new ArrayList<Delivery>();

    @Builder.Default
    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantOperator> restaurantOperator = new ArrayList<RestaurantOperator>();

}
