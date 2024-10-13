package com.kciray.model.order;

import com.kciray.model.BaseEntity;
import com.kciray.model.Restaurant;
import com.kciray.model.User;
import com.kciray.model.status.StatusFullness;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@ToString(exclude = {"restaurant", "user", "statusFullness", "listBasketItem"})
@EqualsAndHashCode(exclude = {"restaurant", "user", "statusFullness", "listBasketItem"})
public class Basket implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_fullness")
    private StatusFullness statusFullness;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketItem> listBasketItem = new ArrayList<>();

}
