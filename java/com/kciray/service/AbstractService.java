package com.kciray.service;


import com.kciray.annotation.Transaction;
import com.kciray.dao.Dao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transaction
public abstract class  AbstractService<K, T, D> {
    @Autowired
    protected Dao<K, T> entityDao;
    protected Class<T> entityClass;
    protected Class<D> entityDtoClass;
    @Autowired
    protected ModelMapper modelMapper;


    protected AbstractService(Class<T> entityClass, Class<D> entityDtoClass, Dao<K, T> entityDao) {
        this.entityDao = entityDao;
        this.entityDtoClass = entityDtoClass;
        this.entityClass = entityClass;

    }

    protected AbstractService() {

    }

    //@Transaction
    public D create(D entityDto) {
        T categoryCardToSave = modelMapper.map(entityDto, entityClass);
        T categoryCardFromSave = entityDao.save(categoryCardToSave);
        return modelMapper.map(categoryCardFromSave, entityDtoClass);
    }


    @Transaction
    public Optional<D> findById(K id) {
        Optional<T> category = entityDao.findById(id);
        return Optional.ofNullable(modelMapper.map(category.orElseThrow(() -> new RuntimeException(String.format("Entity by id = %d does not exist", id))), entityDtoClass));
    }

    public List<D> findAll() {
        List<T> categories = entityDao.findAll();
        return categories.stream().map(entity -> modelMapper.map(entity, entityDtoClass)).collect(Collectors.toList());
    }

    public boolean deleteById(K id) {
        return entityDao.findById(id)
                .map(entity -> {
                    entityDao.delete(id);
                    return true;
                })
                .orElse(false);
    }

    public Optional<D> update(K id, D categoryDto) {
        entityDao.update(modelMapper.map(categoryDto, entityClass));
        return findById(id);

    }
}
