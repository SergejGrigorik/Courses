package com.kciray.mapper;

import com.kciray.dto.CategoryDto;
import com.kciray.dto.DishDto;
import com.kciray.dto.PfccDto;
import com.kciray.dto.RestaurantDto;
import com.kciray.entity.Restaurant;
import com.kciray.entity.menu.Category;
import com.kciray.entity.menu.Dish;
import com.kciray.entity.menu.Pfcc;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DishMapper {
    @Autowired
    private ModelMapper modelMapper;



    public DishDto toDto(Dish dish) {
        return modelMapper.map(dish, DishDto.class);
    }


}
