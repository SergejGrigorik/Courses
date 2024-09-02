package com.kciray.entity.status;

import com.kciray.entity.Restaurant;
import com.kciray.entity.User;
import com.kciray.entity.order.Order;

public class Rating {
    private int id;
    private Order order;
    private String rating;
    private String review;
    private User user;
    private Restaurant restaurant;
}
