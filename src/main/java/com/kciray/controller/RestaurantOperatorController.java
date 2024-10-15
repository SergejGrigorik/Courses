package com.kciray.controller;

import com.kciray.dto.RestaurantOperatorDto;
import com.kciray.service.RestaurantOperatorService;
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

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping("/{id}")
    public RestaurantOperatorDto findById(@PathVariable("id") Integer id) {
        return restaurantOperatorService.findById(id);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping
    public RestaurantOperatorDto create(@RequestBody RestaurantOperatorDto restaurantOperatorDto) {
        return restaurantOperatorService.create(restaurantOperatorDto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PutMapping("/{id}")
    public RestaurantOperatorDto update(@PathVariable("id") Integer id, @RequestBody RestaurantOperatorDto restaurantOperatorDto) {
        return restaurantOperatorService.update(id, restaurantOperatorDto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        restaurantOperatorService.deleteById(id);
    }

}
