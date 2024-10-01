package com.kciray.service.order;

import com.kciray.dto.OrderItemDto;
import com.kciray.model.order.OrderItem;
import com.kciray.repository.OrderItemRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.OrderItemServece;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends AbstractService<Integer, OrderItem, OrderItemDto>
        implements BaseService<Integer, OrderItemDto>, OrderItemServece {

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository){
        super(OrderItem.class,OrderItemDto.class,orderItemRepository);
    }
}
