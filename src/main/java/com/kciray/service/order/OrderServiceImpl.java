package com.kciray.service.order;

import com.kciray.dto.OrderDto;
import com.kciray.model.User;
import com.kciray.model.order.Order;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.OrderRepository;
import com.kciray.service.OrderService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl extends AbstractService<Integer, Order, OrderDto> implements BaseService<Integer, OrderDto>, OrderService {

    private Order order;

    public OrderServiceImpl(OrderRepository orderRepository) {
        super(Order.class, OrderDto.class, orderRepository);
    }

    @Override
    public OrderDto createOrder() {
        createOrderFromBasket();
    }

    private void createOrderFromBasket() {
        Order.builder()
                .user(getUser())
                .coupon()
                .promoCode()
                .statusOrder()
                .statusPayment()
                .build();
    }

    public User getUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(ctx -> ctx.getAuthentication())
                .map(auth -> auth.getPrincipal())
                .filter(p -> p instanceof User)
                .map(u -> ((User) u)).get();
    }
}
