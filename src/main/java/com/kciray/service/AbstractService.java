package com.kciray.service;

import com.kciray.exception.ResourceNotFoundException;
import com.kciray.repository.ApplicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public abstract class AbstractService<K, T, D> {
    @Autowired
    protected ApplicationRepository<K, T> entityRepository;
    protected Class<T> entityClass;
    protected Class<D> entityDtoClass;
    @Autowired
    protected ModelMapper modelMapper;

    protected AbstractService(Class<T> entityClass, Class<D> entityDtoClass, ApplicationRepository<K, T> entityRepository) {
        this.entityRepository = entityRepository;
        this.entityDtoClass = entityDtoClass;
        this.entityClass = entityClass;

    }

    public D create(D entityDto) {
        T categoryCardToSave = modelMapper.map(entityDto, entityClass);
        T categoryCardFromSave = entityRepository.save(categoryCardToSave);
        return modelMapper.map(categoryCardFromSave, entityDtoClass);
    }

    public D findById(K id) {
        return modelMapper.map(entityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Request with id = %id  not found", id))), entityDtoClass);
    }

    public List<D> findAll() {
        List<T> categories = entityRepository.findAll();
        return categories.stream().map(entity -> modelMapper.map(entity, entityDtoClass)).collect(Collectors.toList());

    }

    public void deleteById(K id) {
        entityRepository.findById(id);
        entityRepository.delete(id);

    }

    public D update(K id, D categoryDto) {
        entityRepository.update(modelMapper.map(categoryDto, entityClass));
        return findById(id);
    }
}
