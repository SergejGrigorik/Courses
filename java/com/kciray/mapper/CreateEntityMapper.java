package com.kciray.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateEntityMapper<F,T> {
    @Autowired
    private ModelMapper modelMapper;

    public T toEntity(F entity, Class<T> clazz){

        return modelMapper.map(entity,clazz) ;
    }

}
