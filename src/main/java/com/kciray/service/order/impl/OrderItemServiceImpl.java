package com.kciray.service.order.impl;

import com.kciray.dto.order.OrderItemDto;
import com.kciray.model.menu.Dish;
import com.kciray.model.order.Basket;
import com.kciray.model.order.Order;
import com.kciray.model.order.OrderItem;
import com.kciray.repository.order.OrderItemRepository;
import com.kciray.service.order.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
    private final ModelMapper modelMapper;
    private final OrderItemRepository orderItemRepository;

    public List<OrderItem> createOrderItems(Order order, Basket basket) {
        return basket.getListBasketItem().stream().map(basketItem -> {
                    OrderItem orderItemFromBasket = createOrderItemFromBasket(order, basketItem.getDish(), basketItem.getPrice());
                    return save(orderItemFromBasket);
                }
        ).collect(Collectors.toList());
    }

    private OrderItem createOrderItemFromBasket(Order order, Dish dish, BigDecimal price) {
        return OrderItem.builder()
                .order(order)
                .dish(dish)
                .price(price)
                .build();
    }

    private OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItemDto create(OrderItemDto entity) {
        OrderItem orderItem = modelMapper.map(entity, OrderItem.class);
        return modelMapper.map(orderItemRepository.save(orderItem),OrderItemDto.class);
    }

    @Override
    public OrderItemDto findById(Integer id) {
        return modelMapper.map(orderItemRepository.findById(id),OrderItemDto.class);
    }

    @Override
    public List<OrderItemDto> findAll() {
        return orderItemRepository.findAll().stream().map(orderItem -> modelMapper.map(orderItem,OrderItemDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public OrderItemDto update(Integer id, OrderItemDto entity) {
        return orderItemRepository.update(id,entity);
    }
}
