package com.kciray.mapper.impl;

import com.kciray.mapper.CreateMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateMapperImpl<F,T> implements CreateMapper<F,T> {
    @Autowired
    private ModelMapper modelMapper;

    public T toEntity(F entity, Class<T> clazz) {

        return modelMapper.map(entity,clazz) ;
    }

}
