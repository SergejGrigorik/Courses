package com.kciray.repository.impl;

import com.kciray.repository.PaymentCardRepository;
import com.kciray.model.PaymentCard;
import com.kciray.repository.RepositoryBase;


@org.springframework.stereotype.Repository
public class PaymentCardRepositoryImpl extends RepositoryBase<Integer,PaymentCard> implements PaymentCardRepository {


    public PaymentCardRepositoryImpl() {
        super(PaymentCard.class);
    }
}
