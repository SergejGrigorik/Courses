package com.kciray.repository.impl;

import com.kciray.model.status.CourierStatus;
import com.kciray.repository.CourierRepository;
import com.kciray.model.Courier;
import com.kciray.repository.RepositoryBase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourierRepositoryImpl extends RepositoryBase<Integer,Courier> implements CourierRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CourierRepositoryImpl() {
        super(Courier.class);
    }

    @Override
    public List<Courier> findAllByCourierStatus(CourierStatus courierStatus) {
        return entityManager.createQuery("select c from Courier c where c.courierStatus = :courierStatus",Courier.class)
                .setParameter("courierStatus",courierStatus)
                .getResultList();
    }
}

