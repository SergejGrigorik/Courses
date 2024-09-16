package com.kciray.repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Repository<K, E> {

    E save(E entity);

    void delete(K id);

    void update(E entity);

    default Optional<E> findById(K id){
        return findById(id, Collections.emptyMap());
    }


    Optional<E> findById(K id, Map<String, Object> properties);

    List<E> findAll();
}