package com.kciray.model.status;

import com.kciray.model.Restaurant;
import com.kciray.model.User;
import com.kciray.model.order.Order;

public class Rating {
    private int id;
    private Order order;
    private String rating;
    private String review;
    private User user;
    private Restaurant restaurant;
}
