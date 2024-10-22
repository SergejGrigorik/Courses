package com.kciray.controller.order;

import com.kciray.dto.order.OrderDto;
import com.kciray.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable("id") Integer id) {
        return orderService.findById(id);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        orderService.deleteById(id);
    }

}
