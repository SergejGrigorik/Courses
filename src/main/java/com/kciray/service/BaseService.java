package com.kciray.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BaseService<K,E> {
    E create(E entity);
    Optional<E> findById(K id);
    List<E> findAll();
    boolean deleteById(K id);
    Optional<E> update(K id,E entity);


}

