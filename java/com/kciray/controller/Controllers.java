package com.kciray.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.kciray.service.BaseService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


public abstract  class Controllers<E> {

    private BaseService<Integer, E> services;
    @Autowired
    private ObjectMapper objectMapper;

    public Controllers(BaseService<Integer, E> services) {
        this.services = services;

    }

//    public Controllers() {
//
//    }


    public void create(E entityDto) {
        try {
            System.out.println(objectMapper.writeValueAsString(services.create(entityDto)));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows

    public E findById(Integer id) {
        E entityDao = services.findById(id).get();
//        System.out.println(objectMapper.writeValueAsString(entityDao));
        return entityDao;
    }

    public void deleteById(Integer id) {
        System.out.println(services.deleteById(id));

    }

    public void update(Integer id, E entityDto) {
        services.update(id, entityDto);
    }
}
