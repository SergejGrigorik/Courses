package com.kciray.dao;

import com.kciray.database.PaymentCardDataBase;
import com.kciray.entity.PaymentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class PaymentCardDao extends AbstractDao<PaymentCard> {


    @Autowired
    public PaymentCardDao(PaymentCardDataBase paymentCardDataBase) {
        super(paymentCardDataBase);
    }
}
