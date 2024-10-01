package com.kciray.controller.impl;

import com.kciray.dto.RestaurantDto;
import com.kciray.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/restaurant")
public class RestaurantController  {

    private final RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantDto> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/{id}")
    public RestaurantDto findById(@PathVariable("id") Integer id) {
        return restaurantService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public RestaurantDto create(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.create(restaurantDto);
    }

    @PutMapping("/{id}")
    public RestaurantDto update(@PathVariable("id") Integer id, @RequestBody RestaurantDto restaurantDto) {
        return restaurantService.update(id,restaurantDto)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        if(restaurantService.deleteById(id))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
