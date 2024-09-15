package com.kciray.repository.impl;

import com.kciray.repository.PaymentCardDao;
import com.kciray.model.PaymentCard;
import com.kciray.repository.RepositoryBase;


@org.springframework.stereotype.Repository
public class PaymentCardRepositoryImpl extends RepositoryBase<Integer,PaymentCard> implements PaymentCardDao {


    public PaymentCardRepositoryImpl() {
        super(PaymentCard.class);
    }
}
