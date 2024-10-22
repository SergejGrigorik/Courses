package com.kciray.controller.order;

import com.kciray.dto.order.OrderItemDto;
import com.kciray.service.order.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orderitem")
public class OrderItemController {

    private final OrderItemService orderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderItemDto> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderItemDto findById(@PathVariable("id") Integer id) {
        return orderService.findById(id);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderItemDto create(@RequestBody OrderItemDto orderItemDto) {
        return orderService.create(orderItemDto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PutMapping("/{id}")
    public OrderItemDto update(@PathVariable("id") Integer id, @RequestBody OrderItemDto orderItemDto) {
        return orderService.update(id, orderItemDto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        orderService.deleteById(id);
    }

}
