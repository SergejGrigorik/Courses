package com.kciray.repository;

import com.kciray.model.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public abstract class RepositoryBase<K extends Serializable, E extends BaseEntity<K>> implements Repository<K, E> {
    public  Class<E> clazz;
    @PersistenceContext
    protected EntityManager entityManager;
    public RepositoryBase(Class<E> clazz){
        this.clazz = clazz;

    }
    public RepositoryBase(){

    }

    @Override
    public E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(K id) {
        entityManager.remove(entityManager.find(clazz, id));

    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);

    }

    @Override
    public Optional<E> findById(K id, Map<String, Object> properties) {

        return Optional.ofNullable(entityManager.find(clazz, id, properties));
    }

    @Override
    public List<E> findAll() {
        CriteriaQuery<E> criteria = entityManager.getCriteriaBuilder().createQuery(clazz);

        return entityManager.createQuery(criteria)
                .getResultList();
    }
}