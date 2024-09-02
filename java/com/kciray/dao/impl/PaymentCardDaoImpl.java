package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.Dao;
import com.kciray.dao.PaymentCardDao;
import com.kciray.database.PaymentCardDataBase;
import com.kciray.entity.PaymentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class PaymentCardDaoImpl  implements PaymentCardDao, Dao<Integer,PaymentCard> {


    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public PaymentCard save(PaymentCard ticket) {
        return null;
    }

    @Override
    public void update(PaymentCard ticket) {

    }

    @Override
    public Optional<PaymentCard> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<PaymentCard> findAll() {
        return List.of();
    }
}
