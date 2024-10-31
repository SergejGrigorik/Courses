package com.kciray.repository.order;

import com.kciray.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>, OrderItemUpdateRepository {

}
