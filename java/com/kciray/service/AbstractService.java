package com.kciray.service;

import com.kciray.dao.AbstractDao;
import com.kciray.mapper.CreateMapper;
import com.kciray.mapper.ReadMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public abstract class AbstractService<T, D> {
    @Autowired
    private AbstractDao<T> entityDao;

    @Autowired
    private ReadMapper<T, D> readMapper;


    @Autowired
    private CreateMapper<D, T> createdMapper;

    private Class<T> entity;
    private Class<D> entityDto;


    protected AbstractService(Class<T> clazz, Class<D> dClass, AbstractDao<T> dClasss) {
        this.entityDao = dClasss;
        this.entityDto = dClass;
        this.entity = clazz;

    }

    public D create(D categoryDto) {
        T categoryCardToSave = createdMapper.toEntity(categoryDto, entity);
        T categoryCardFromSave =  entityDao.save( categoryCardToSave);
        return readMapper.toDto(categoryCardFromSave, entityDto);
    }


    public Optional<D> findById(Integer id) {
        Optional<T> category = entityDao.findById(id);
        return Optional.ofNullable(readMapper.toDto( category.orElseThrow(() -> new RuntimeException(String.format("++Entity by id = %d does not exist", id))), entityDto));
    }

    public List<D> findAll() {
        List<T> categories = entityDao.findAll();
        return categories.stream().map(entity -> readMapper.toDto( entity, entityDto)).collect(Collectors.toList());
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
        entityDao.update(id, createdMapper.toEntity(categoryDto, entity));
        return findById(id);

    }
}
