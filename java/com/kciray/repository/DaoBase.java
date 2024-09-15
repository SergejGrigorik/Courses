package com.kciray.repository;

import java.io.Serializable;
import java.util.List;

public interface DaoBase<K extends Serializable,E> {
     E save(K id,E entity);
     E update(K id,E entity);
     void delete(K id);
     List<E> findAll();
     E findById(K id);
}
