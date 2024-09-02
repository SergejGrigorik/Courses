package com.kciray.entity.order;

import com.kciray.entity.Restaurant;
import com.kciray.entity.User;
import com.kciray.entity.status.StatusFullness;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Basket {
    private int id;
    private Restaurant restaurant;
    private User user;
    private StatusFullness statusFullness;
}
