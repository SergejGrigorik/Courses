package com.kciray.repository.order;

import com.kciray.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order,Integer> {

}
