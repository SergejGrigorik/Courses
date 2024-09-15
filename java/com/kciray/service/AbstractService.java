package com.kciray.service;

import com.kciray.repository.Repository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public abstract class  AbstractService<K, T, D> {
    @Autowired
    protected Repository<K, T> entityRepository;
    protected Class<T> entityClass;
    protected Class<D> entityDtoClass;
    @Autowired
    protected ModelMapper modelMapper;


    protected AbstractService(Class<T> entityClass, Class<D> entityDtoClass, Repository<K, T> entityRepository) {
        this.entityRepository = entityRepository;
        this.entityDtoClass = entityDtoClass;
        this.entityClass = entityClass;

    }

    protected AbstractService() {

    }
    @Transactional
    public D create(D entityDto) {
        T categoryCardToSave = modelMapper.map(entityDto, entityClass);
        T categoryCardFromSave = entityRepository.save(categoryCardToSave);
        return modelMapper.map(categoryCardFromSave, entityDtoClass);
    }

    @Transactional
    public Optional<D> findById(K id) {
        Optional<T> category = entityRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(category.orElseThrow(() -> new RuntimeException(String.format("Entity by id = %d does not exist", id))), entityDtoClass));
    }
    @Transactional
    public List<D> findAll() {
        List<T> categories = entityRepository.findAll();
        return categories.stream().map(entity -> modelMapper.map(entity, entityDtoClass)).collect(Collectors.toList());
    }
    @Transactional
    public boolean deleteById(K id) {
        return entityRepository.findById(id)
                .map(entity -> {
                    entityRepository.delete(id);
                    return true;
                })
                .orElse(false);
    }
    @Transactional
    public Optional<D> update(K id, D categoryDto) {

        entityRepository.update(modelMapper.map(categoryDto, entityClass));
        return findById(id);

    }
}
