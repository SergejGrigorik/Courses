package com.kciray.mapper;

import com.kciray.dto.CategoryDto;
import com.kciray.entity.menu.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    @Autowired
    private ModelMapper modelMapper;
    public CategoryDto toDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }
}
