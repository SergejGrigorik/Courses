package com.kciray.repository.impl;


import com.kciray.model.Restaurant;
import com.kciray.model.Restaurant_;
import com.kciray.model.address.Address;
import com.kciray.repository.RepositoryBase;
import com.kciray.repository.RestaurantRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class RestaurantRepositoryImpl extends RepositoryBase<Integer, Restaurant> implements RestaurantRepository {

    public RestaurantRepositoryImpl() {
        super(Restaurant.class);
    }

    @Override
    public Optional<Restaurant> findById(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Restaurant> query = cb.createQuery(Restaurant.class);
        Root<Restaurant> restaurantRoot = query.from(Restaurant.class);
        query.select(restaurantRoot).where(cb.equal(restaurantRoot.get(Restaurant_.id), id));
        return entityManager.createQuery(query).getResultList().stream().findFirst();
    }

    @Override
    public List<Restaurant> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Restaurant> query = criteriaBuilder.createQuery(Restaurant.class);
        Root<Restaurant> from = query.from(Restaurant.class);
        query.select(from);
        return entityManager.createQuery(query).getResultList();

    }

    public Restaurant findAddressAndRestaurantById(Integer id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Restaurant> query = cb.createQuery(Restaurant.class);
        Root<Restaurant> restaurantRoot = query.from(Restaurant.class);
        Join<Restaurant, Address> restaurantAddressJoin = restaurantRoot.join(Restaurant_.address);
        restaurantRoot.fetch(Restaurant_.address);
        query.select(restaurantRoot).where(cb.equal(restaurantRoot.get(Restaurant_.id), id));
        return entityManager.createQuery(query).getSingleResult();
    }
}
