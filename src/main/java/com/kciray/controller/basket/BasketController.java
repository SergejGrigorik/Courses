package com.kciray.controller.basket;

import com.kciray.dto.BasketDto;
import com.kciray.dto.DishDto;
import com.kciray.model.menu.Dish;
import com.kciray.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/basket")
public class BasketController {


    private final BasketService basketService;

    @PostMapping("/addDish")
    public Dish addDishInBasket(@RequestBody DishDto dto) {
        return basketService.addDish(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BasketDto> findAll() {

        return basketService.findAll();
    }

    @GetMapping("/{id}")
    public BasketDto findById(@PathVariable("id") Integer id) {

        return basketService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public BasketController create(@RequestBody BasketController basketController) {
//        return basketService.create(addressDto);
//    }

    @PutMapping("/{id}")
    public BasketDto update(@PathVariable("id") Integer id, @RequestBody BasketDto basketController) {
        return basketService.update(id, basketController)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (basketService.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }





}
