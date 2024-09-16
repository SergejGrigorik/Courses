package com.kciray.model.order;

import com.kciray.model.Restaurant;
import com.kciray.model.User;
import com.kciray.model.status.StatusFullness;
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
public class Basket {

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

    @OneToMany(mappedBy = "basket")
    private List<BasketItem> list = new ArrayList<>();

}
