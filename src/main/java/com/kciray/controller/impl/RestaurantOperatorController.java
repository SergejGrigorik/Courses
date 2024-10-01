package com.kciray.controller.impl;

import com.kciray.dto.PfccDto;
import com.kciray.dto.RestaurantOperatorDto;
import com.kciray.model.RestaurantOperator;
import com.kciray.service.PfccService;
import com.kciray.service.RestaurantOperatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/restaurantoperator")
public class RestaurantOperatorController {

    private final RestaurantOperatorService restaurantOperatorService;

    @GetMapping
    public List<RestaurantOperatorDto> findAll() {

        return restaurantOperatorService.findAll();
    }

    @GetMapping("/{id}")
    public RestaurantOperatorDto findById(@PathVariable("id") Integer id) {
        return restaurantOperatorService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public RestaurantOperatorDto create(@RequestBody RestaurantOperatorDto restaurantOperatorDto) {
        return restaurantOperatorService.create(restaurantOperatorDto);
    }

    @PutMapping("/{id}")
    public RestaurantOperatorDto update(@PathVariable("id") Integer id, @RequestBody RestaurantOperatorDto restaurantOperatorDto) {
        return restaurantOperatorService.update(id,restaurantOperatorDto)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        if(restaurantOperatorService.deleteById(id))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
