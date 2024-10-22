package com.kciray.service.order.impl;

import com.kciray.dto.order.OrderDto;
import com.kciray.exception.EmptyBasketException;
import com.kciray.model.Coupon;
import com.kciray.model.User;
import com.kciray.model.order.Basket;
import com.kciray.model.order.Order;
import com.kciray.model.status.StatusOrder;
import com.kciray.model.status.Validity;
import com.kciray.repository.CouponRepository;
import com.kciray.repository.basket.BasketItemRepository;
import com.kciray.repository.basket.BasketRepository;
import com.kciray.repository.order.OrderRepository;
import com.kciray.service.order.OrderItemService;
import com.kciray.service.order.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final BasketRepository basketRepository;
    private final BasketItemRepository basketItemRepository;
    private final CouponRepository couponRepository;
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final ModelMapper modelMapper;
    private Order order;
    private String promoCode;
    private Basket basket;
    private Coupon coupon;

    public Order getOrder(String promoCode) {
        this.promoCode = promoCode;
        basket = basketRepository.findByUserId(getUser().getId()).orElseThrow(() -> new EmptyBasketException("Your basket is empty"));
        createOrder();
        Order saveOrder = orderRepository.saveAndFlush(order);
        orderItemService.createOrderItems(saveOrder, basket);
        basketRepository.delete(basket);
        modelMapper.map(saveOrder, OrderDto.class);
        return saveOrder;
    }

    @Override
    public OrderDto findById(Integer id) {
        return modelMapper.map(orderRepository.findById(id), OrderDto.class);
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> allOrder = orderRepository.findAll();
        return allOrder.stream().map(entity -> modelMapper.map(entity, OrderDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(1);

    }

    private void createOrder() {
        if (hasPromocod()) {
            order = createOrderWithPromoCod();
        } else {
            order = createOrderWithOutPromoCod();
        }
    }

    private boolean hasPromocod() {
        if (promoCode != null) {
            coupon = couponRepository.findByPromoCodeAndRestaurantId(promoCode, basket.getRestaurant().getId());
            if (coupon.getValidity().equals(Validity.VALID)) {
                coupon.setValidity(Validity.INVALID);
                couponRepository.updateValidity(coupon.getValidity(), coupon.getId());
                return true;
            } else {
                throw new RuntimeException("Your promoCode is invalid ");
            }
        }
        return false;
    }

    private Order createOrderWithPromoCod() {
        BigDecimal subtract = BigDecimal.valueOf(coupon.getDiscount()).divide(BigDecimal.valueOf(100));
        BigDecimal discount = sumPrice().multiply(subtract);
        BigDecimal sumPrice = sumPrice().subtract(discount);
        return Order.builder()
                .user(getUser())
                .sumPrice(sumPrice)
                .coupon(coupon)
                .promoCode(promoCode)
                .statusOrder(StatusOrder.ACCEPTED)
                .build();
    }

    private Order createOrderWithOutPromoCod() {
        return Order.builder()
                .user(getUser())
                .sumPrice(sumPrice())
                .statusOrder(StatusOrder.ACCEPTED)
                .build();
    }

    private BigDecimal sumPrice() {
        return basket.getListBasketItem().stream()
                .map(basketItem -> basketItem.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public User getUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(ctx -> ctx.getAuthentication())
                .map(auth -> auth.getPrincipal())
                .filter(p -> p instanceof User)
                .map(u -> ((User) u)).get();
    }
}
