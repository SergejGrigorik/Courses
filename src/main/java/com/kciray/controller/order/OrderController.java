package com.kciray.controller.order;


import com.kciray.dto.AddressDto;
import com.kciray.dto.OrderDto;
import com.kciray.model.address.Address;
import com.kciray.model.order.Order;
import com.kciray.service.AbstractService;
import com.kciray.service.AddressService;
import com.kciray.service.BaseService;
import com.kciray.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/order")
public class OrderController  {

    private final OrderService orderService;


    @GetMapping("/order")
    public OrderDto createOrder() {
        return orderService.createOrder();
    }


}
