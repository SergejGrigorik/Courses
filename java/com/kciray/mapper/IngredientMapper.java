package com.kciray.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kciray.dto.IngredientDto;
import com.kciray.entity.menu.Ingredient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class IngredientMapper {
    @Autowired
    private ModelMapper modelMapper;

    public IngredientDto toDto(Ingredient ingredient) {
        return modelMapper.map(ingredient, IngredientDto.class);
    }

}
