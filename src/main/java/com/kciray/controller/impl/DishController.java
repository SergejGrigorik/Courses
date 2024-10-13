package com.kciray.controller.impl;

import com.kciray.dto.entityfilter.DishFilter;
import com.kciray.dto.menu.DishDto;
import com.kciray.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/dish")
public class DishController {

    private final DishService dishService;

    @GetMapping
    public List<DishDto> findAllDish(Pageable pageable) {
        return dishService.findAllBy(pageable);
    }

    @GetMapping("/filter")
    public List<DishDto> findAllByFilter(@ParameterObject DishFilter dishFilter) {
        return dishService.findAllByFilter(dishFilter);
    }

    @GetMapping("/page")
    public List<DishDto> findAllByPage(Pageable pageable) {
        return dishService.findAllBy(pageable);
    }

    @GetMapping("/findAllDishBy")
    List<DishDto> findAllDishByRestaurantIdAndCategoryById(@ParameterObject Integer restId, @ParameterObject Integer catId) {
        return dishService.findAllDishByRestaurantIdAndCategoryById(restId, catId);
    }


    @GetMapping("/{id}")
    public DishDto findById(@PathVariable("id") Integer id) {
        return dishService.findById(id);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping
    public DishDto create(@RequestBody DishDto dto) {
        return dishService.create(dto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PutMapping("/{id}")
    public DishDto update(@PathVariable("id") Integer id, @RequestBody DishDto dto) {
        return dishService.update(id, dto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        dishService.deleteById(id);
    }
}
