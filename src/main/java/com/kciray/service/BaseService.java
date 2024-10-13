package com.kciray.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<K, E> {
    E create(E entity);

    E findById(K id);

    List<E> findAll();

    void deleteById(K id);

    E update(K id, E entity);


}

