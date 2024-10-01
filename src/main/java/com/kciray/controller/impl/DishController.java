package com.kciray.controller.impl;

import com.kciray.dto.DishDto;


import com.kciray.dto.UserDto;
import com.kciray.dto.entityfilter.DishFilter;
import com.kciray.model.menu.Dish;
import com.kciray.service.BaseService;
import com.kciray.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/dish")
public class DishController  {

    private final DishService dishService;

    @GetMapping
    public List<DishDto> findDish(Pageable pageable) {

        return dishService.findAllBy(pageable);
    }

    @GetMapping("/filter" )
    public List<DishDto> findAllByFilter(@ParameterObject DishFilter dishFilter){
        return dishService.findAllByFilter(dishFilter);
    }

    @GetMapping("/page")
    public List<DishDto>findAllByPage(Pageable pageable){
        return dishService.findAllBy(pageable);
    }

    @GetMapping("/restandcat")
    List<DishDto> findAllDishByRestaurantIdAndCategoryById(@ParameterObject Integer restId,@ParameterObject Integer catId){
        return dishService.findAllDishByRestaurantIdAndCategoryById(restId,catId);
    }


    @GetMapping("/{id}")
    public DishDto findById(@PathVariable("id") Integer id) {
        return dishService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public DishDto create(@RequestBody DishDto dto) {
        return dishService.create(dto);
    }

    @PutMapping("/{id}")
    public DishDto update(@PathVariable("id") Integer id, @RequestBody DishDto dto) {
        return dishService.update(id,dto)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        if(dishService.deleteById(id))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
