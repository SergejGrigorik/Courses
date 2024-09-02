package com.kciray.mapper.impl;

import com.kciray.mapper.ReadMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadEntityMapperImpl<F,T> implements ReadMapper<F,T> {
    @Autowired
    private ModelMapper modelMapper;

    public T toDto(F entity, Class<T> clazz){


        return modelMapper.map(entity,clazz) ;
    }
}
