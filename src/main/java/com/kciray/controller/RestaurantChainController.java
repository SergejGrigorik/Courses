package com.kciray.controller;

import com.kciray.dto.RestaurantChainDto;
import com.kciray.service.RestaurantChainService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/restaurantChain")
public class RestaurantChainController {

    private final RestaurantChainService restaurantChainService;

    @PreAuthorize("hasRole('OPERATOR')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<RestaurantChainDto> findAll() {
        return restaurantChainService.findAll();
    }

    @PreAuthorize("hasRole('OPERATOR')")
    @GetMapping(("/{id}"))
    public RestaurantChainDto findById(@PathVariable("id") Integer id) {
        return restaurantChainService.findById(id);
    }

    @PreAuthorize("hasRole('OPERATOR')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantChainDto create(@RequestBody @Valid RestaurantChainDto restaurantChainDto) {
        return restaurantChainService.create(restaurantChainDto);
    }

    @PreAuthorize("hasRole('OPERATOR')")
    @PutMapping("/{id}")
    public RestaurantChainDto update(@PathVariable("id") Integer id, @RequestBody RestaurantChainDto restaurantChainDto) {
        return restaurantChainService.update(id, restaurantChainDto);
    }

    @PreAuthorize("hasRole('DELETE_RESTAURANT_CHAIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        restaurantChainService.deleteById(id);
    }
}
