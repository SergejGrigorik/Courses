package com.kciray.service;

import com.kciray.dao.AbstractDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public abstract class AbstractService<T, D> {
    @Autowired
    private AbstractDao<T> entityDao;
    private Class<T> entityClass;
    private Class<D> entityDtoClass;
    @Autowired
    private ModelMapper modelMapper;


    protected AbstractService(Class<T> entityClass, Class<D> entityDtoClass, AbstractDao<T> entityDao) {
        this.entityDao = entityDao;
        this.entityDtoClass = entityDtoClass;
        this.entityClass = entityClass;

    }

    public D create(D entityDto) {
        T categoryCardToSave = modelMapper.map(entityDto, entityClass);
        T categoryCardFromSave =  entityDao.save( categoryCardToSave);
        return modelMapper.map(categoryCardFromSave, this.entityDtoClass);
    }


    public Optional<D> findById(Integer id) {
        Optional<T> category = entityDao.findById(id);
        return Optional.ofNullable(modelMapper.map( category.orElseThrow(() -> new RuntimeException(String.format("Entity by id = %d does not exist", id))), entityDtoClass));
    }

    public List<D> findAll() {
        List<T> categories = entityDao.findAll();
        return categories.stream().map(entity -> modelMapper.map( entity, entityDtoClass)).collect(Collectors.toList());
    }

    public boolean deleteById(Integer id) {
        return entityDao.findById(id)
                .map(entity -> {
                    entityDao.delete(id);
                    return true;
                })
                .orElse(false);
    }

    public Optional<D> update(Integer id, D categoryDto) {
        entityDao.update(id, modelMapper.map(categoryDto, entityClass));
        return findById(id);

    }
}
