package com.kciray.repository.impl;

import com.kciray.model.order.BasketItem;
import com.kciray.repository.BasketItemRepository;
import com.kciray.repository.RepositoryBase;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository
public class BasketItemRepositoryImpl extends RepositoryBase<Integer, BasketItem> implements BasketItemRepository {


    public BasketItemRepositoryImpl (){
        super(BasketItem.class);
    }

    @Override
    public boolean deleteAll() {
        String hql = String.format("delete from %s",BasketItem.class);
        Query query = entityManager.createQuery(hql);
        query.executeUpdate();
        return true;

    }
}
