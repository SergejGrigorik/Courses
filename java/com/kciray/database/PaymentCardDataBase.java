package com.kciray.database;

import com.kciray.entity.PaymentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;



public class PaymentCardDataBase implements DataBase<Integer, PaymentCard>{


    private static PaymentCardDataBase paymentCardDataBase;
    private Map<Integer, PaymentCard> dataBaseMap = new HashMap<>();

    private GenerationId<PaymentCard> generationId;

    private PaymentCardDataBase() {

    }

    public static PaymentCardDataBase getInstance() {
        if (paymentCardDataBase == null) {
            paymentCardDataBase = new PaymentCardDataBase();
        }
        return paymentCardDataBase;
    }


    @Override
    public Map<Integer,PaymentCard> getMapDataBase() {
        return dataBaseMap;
    }

    public PaymentCard getEntityFromDataBase(PaymentCard paymentCard) {
    return generationId.addEntityDataBase(paymentCard, dataBaseMap);
    }

}
