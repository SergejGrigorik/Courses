package com.kciray.repository.impl;

import com.kciray.model.menu.Category;
import com.kciray.model.order.Basket;

import com.kciray.model.order.BasketItem;
import com.kciray.repository.BasketRepository;
import com.kciray.repository.RepositoryBase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class BasketRepositoryImpl extends RepositoryBase<Integer,Basket> implements BasketRepository {

    @PersistenceContext
    protected EntityManager entityManager;

    public BasketRepositoryImpl (){
        super(Basket.class);
    }


    @Override
    public void addDish() {

    }

    @Override
    public void addIngredient() {

    }

    @Override
    public Basket saveBasket(Basket build) {
        return entityManager.merge(build);
    }

    @Override
    public BasketItem saveBasketItem(BasketItem build) {
        return entityManager.merge(build);
    }


    @Override
    public Optional<Basket> findByUserId(Integer id) {
        return entityManager.createQuery("select b from Basket b where b.user.id = :id", Basket.class)
                .setParameter("id",id)
                .getResultList().stream().findFirst();
    }
}
