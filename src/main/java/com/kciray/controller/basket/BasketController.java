package com.kciray.controller.basket;

import com.kciray.dto.menu.DishDto;
import com.kciray.model.menu.Dish;
import com.kciray.service.basket.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/basket")
public class BasketController {

    private final BasketService basketService;

    @PostMapping("/addDish")
    public Dish addDishInBasket(@RequestBody DishDto dto) {
        return basketService.addDish(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        basketService.deleteById(id);
    }
}
