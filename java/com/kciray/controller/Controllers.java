package com.kciray.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kciray.service.Services;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class Controllers<E> {
    //    @Autowired
    private Services<Integer, E> services;
    @Autowired
    private ObjectMapper objectMapper;

    public Controllers(Services<Integer, E> services) {
        this.services = services;

    }

    @SneakyThrows
    public void create(E entityDto) {
        System.out.println(objectMapper.writeValueAsString(services.create(entityDto)));
    }

    @SneakyThrows
    public E findByid(Integer id) {
        E entityDao = services.findById(id).get();
        System.out.println(objectMapper.writeValueAsString(entityDao));
        return entityDao;
    }

    public void deleteById(Integer id) {
        System.out.println(services.deleteById(id));

    }

    public void update(Integer id, E entityDto) {
        services.update(id, entityDto);
    }
}
