package com.kciray.repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ApplicationRepository<K, E> {

    E save(E entity);

    void delete(K id);

    void update(E entity);
//    default void update(Integer id , E entity){
//
//        update(entity);
//    };

    Optional<E> findById(K id);



    List<E> findAll();
}