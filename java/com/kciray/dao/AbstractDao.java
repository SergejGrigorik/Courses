package com.kciray.dao;

import com.kciray.database.DataBase;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.*;

@Component
public abstract class AbstractDao<E> {

    private Map<Integer, E> map ;
    DataBase db ;

    protected AbstractDao(DataBase<Integer, E> db) {
        map = db.getMapDataBase();
        this.db = db;
    }

    public E save( E entity) throws SQLException {
        return (E) db.getEntityFromDataBase(entity);
    }


    public E update(Integer id, E entity) {
        if (!map.containsKey(id)) {
            throw new IllegalArgumentException(String.format("Entity by id = %d does not exist", id));
        }
        map.put(id, entity);
        return map.get(id);
    }


    public void delete(Integer id) {
        if (!map.containsKey(id)) {
            throw new IllegalArgumentException(String.format("Entity by id = %d does not exist", id));
        }
        map.remove(id);
    }


    public List<E> findAll() {
        return new ArrayList<>(map.values());
    }


    public Optional<E> findById(Integer id) {
        if (!map.containsKey(id)) {
            throw new IllegalArgumentException(String.format("Entity by id = %d does not exist", id));
        }
        return Optional.ofNullable( map.get(id));
    }
}
