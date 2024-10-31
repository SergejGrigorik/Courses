package com.kciray.controller;

import com.kciray.dto.RestaurantDto;
import com.kciray.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping
    public List<RestaurantDto> findAll() {
        return restaurantService.findAll();
    }

    @PreAuthorize("hasRole('READ_RESTAURANT')")
    @GetMapping("/{id}")
    public RestaurantDto findById(@PathVariable("id") Integer id) {
        return restaurantService.findById(id);
    }

    @PreAuthorize("hasRole('OPERATOR')")
    @PostMapping
    public RestaurantDto create(@RequestBody @Valid RestaurantDto restaurantDto) {
        return restaurantService.create(restaurantDto);
    }

    @PreAuthorize("hasRole('OPERATOR')")
    @PutMapping("/{id}")
    public RestaurantDto update(@PathVariable("id") Integer id, @RequestBody @Valid  RestaurantDto restaurantDto) {
        return restaurantService.update(id, restaurantDto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        restaurantService.deleteById(id);
    }

}
