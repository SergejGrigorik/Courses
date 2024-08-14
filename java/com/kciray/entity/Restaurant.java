package com.kciray.entity;

import com.kciray.entity.address.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Component
public class Restaurant {
    private int id;
    private RestaurantChain restaurantChain;
    private int accountBank;
    private String locationCoordinates;
    private Address address;
    private int number;
}
