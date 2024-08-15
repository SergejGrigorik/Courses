package com.kciray.mapper;

import com.kciray.dto.CityDto;
import com.kciray.dto.RegionDto;
import com.kciray.entity.address.City;
import com.kciray.entity.address.Region;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Example {
    private ModelMapper modelMapper;

    @Autowired
    public Example (ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

    }


    public CityDto toDto(City entity, Class<CityDto> clazz) {
        modelMapper.createTypeMap(Region.class, RegionDto.class);
        return modelMapper.map(entity, clazz);
    }


}
