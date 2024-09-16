package com.kciray.repository.impl;

import com.kciray.model.Restaurant_;
import com.kciray.model.menu.Category_;
import com.kciray.model.menu.Dish;
import com.kciray.model.menu.Dish_;
import com.kciray.repository.DishRepository;
import com.kciray.repository.RepositoryBase;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

@org.springframework.stereotype.Repository
public class DishRepositoryImpl extends RepositoryBase<Integer, Dish> implements DishRepository {

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
}
