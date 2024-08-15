package com.kciray.mapper.interfaceMapper;

import com.kciray.dto.DishDto;
import com.kciray.entity.menu.Dish;
import org.modelmapper.ModelMapper;
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
