package com.kciray.repository.impl;

import com.kciray.model.menu.Category;
import com.kciray.repository.CategoryRepository;
import com.kciray.repository.RepositoryBase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl extends RepositoryBase<Integer, Category> implements CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public CategoryRepositoryImpl() {
        super(Category.class);
    }

    @Override
    public void delete(Integer id) {
        entityManager.createQuery("delete Category c where c.id = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void update(Category entity) {
        entityManager.createQuery("update Category c " +
                                  "set c.name = :name " +
                                  "where c.id = :id")
                .setParameter("name", entity.getName())
                .setParameter("id", entity.getId())
                .executeUpdate();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return entityManager.createQuery("select c from Category c where c.id = :id", Category.class)
                .setParameter("id", id)
                .getResultList().stream().findFirst();
    }

    public Optional<Category> findCategoryWithDishById(Integer id) {
        return entityManager.createQuery("select c from Category c join fetch c.dishes where c.id = :id", Category.class)
                .setParameter("id", id)
                .getResultList().stream().findFirst();
    }

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("select c from Category c ", Category.class).getResultList();
    }

}
