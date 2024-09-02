package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.PaymentCardDao;
import com.kciray.database.PaymentCardDataBase;
import com.kciray.entity.PaymentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PaymentCardDaoImpl extends AbstractDao<PaymentCard> implements PaymentCardDao {


    @Autowired
    public PaymentCardDaoImpl(PaymentCardDataBase paymentCardDataBase) {
        super(paymentCardDataBase);
    }
}
