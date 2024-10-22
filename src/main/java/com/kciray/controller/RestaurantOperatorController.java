package com.kciray.controller;

import com.kciray.dto.RestaurantOperatorDto;
import com.kciray.service.RestaurantOperatorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/restaurantoperator")
public class RestaurantOperatorController {

    private final RestaurantOperatorService restaurantOperatorService;

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping
    public List<RestaurantOperatorDto> findAll() {
        return restaurantOperatorService.findAll();
    }

    @PreAuthorize("hasRole('READ_RESTAURANT_OPERATOR')")
    @GetMapping("/{id}")
    public RestaurantOperatorDto findById(@PathVariable("id") Integer id) {
        return restaurantOperatorService.findById(id);
    }

    @PreAuthorize("hasRole('OPERATOR')")
    @PostMapping
    public RestaurantOperatorDto create(@RequestBody @Valid RestaurantOperatorDto restaurantOperatorDto) {
        return restaurantOperatorService.create(restaurantOperatorDto);
    }

    @PreAuthorize("hasRole('OPERATOR')")
    @PutMapping("/{id}")
    public RestaurantOperatorDto update(@PathVariable("id") Integer id, @RequestBody @Valid  RestaurantOperatorDto restaurantOperatorDto) {
        return restaurantOperatorService.update(id, restaurantOperatorDto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        restaurantOperatorService.deleteById(id);
    }

}
