package com.kciray.repository.impl;

import com.kciray.dto.entityfilter.DishFilter;
import com.kciray.model.Restaurant_;
import com.kciray.model.menu.Category_;
import com.kciray.model.menu.Dish;
import com.kciray.model.menu.Dish_;
import com.kciray.repository.DishRepository;
import com.kciray.repository.RepositoryBase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class DishRepositoryImpl extends RepositoryBase<Integer, Dish> implements DishRepository {

    @PersistenceContext
    private EntityManager em;

    public DishRepositoryImpl() {
        super(Dish.class);
    }

    public List<Dish> findAllDishByRestaurantIdAndCategoryById(Integer restaurantId, Integer categoryId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dish> query = cb.createQuery(Dish.class);
        Root<Dish> restaurantRoot = query.from(Dish.class);
        restaurantRoot.join(Dish_.restaurant);
        restaurantRoot.fetch(Dish_.category);
        query.select(restaurantRoot).where(
                cb.equal(restaurantRoot.get(Dish_.restaurant).get(Restaurant_.id), restaurantId),
                cb.equal(restaurantRoot.get(Dish_.category).get(Category_.id), categoryId));
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    public List<Dish> findAllBy(Pageable pageable) {
        return em.createQuery("select d from Dish d order by d.id ", Dish.class)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
    }

    @Override
    public List<Dish> findAllByFilter(DishFilter dishFilter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dish> query = cb.createQuery(Dish.class);
        Root<Dish> from = query.from(Dish.class);
        from.join(Dish_.restaurant);
        query.select(from);
        List<Predicate> predicates = new ArrayList<>();
        if (dishFilter.name() != null) {
            predicates.add(cb.like(from.get(Dish_.name), "%" + dishFilter.name() + "%"));
        }
        if (dishFilter.fromPrice() != null && dishFilter.toPrice() != null) {
            predicates.add(cb.between(from.get(Dish_.price), dishFilter.fromPrice(), dishFilter.toPrice()));
        }
        if (dishFilter.fromPrice() != null) {
            predicates.add(cb.gt(from.get(Dish_.price), dishFilter.fromPrice()));
        }
        if (dishFilter.toPrice() != null) {
            predicates.add(cb.le(from.get(Dish_.price), dishFilter.toPrice()));
        }
        if (dishFilter.fromWeight() != null) {
            predicates.add(cb.gt(from.get(Dish_.weight), dishFilter.fromWeight()));
        }
        if (dishFilter.toWeight() != null) {
            predicates.add(cb.le(from.get(Dish_.weight), dishFilter.toWeight()));
        }
        if (dishFilter.restaurantId() != null) {
            predicates.add(cb.equal(from.get(Dish_.restaurant).get(Restaurant_.id), dishFilter.restaurantId()));
        }
        if (dishFilter.categoryId() != null) {
            predicates.add(cb.equal(from.get(Dish_.category).get(Category_.id), dishFilter.categoryId()));
        }

        if (dishFilter.fromWeight() != null && dishFilter.toWeight() != null) {
            predicates.add(cb.between(from.get(Dish_.weight), dishFilter.fromWeight(), dishFilter.toWeight()));
        }
        query.where(predicates.toArray(Predicate[]::new));
        return entityManager.createQuery(query).getResultList();
    }

}



