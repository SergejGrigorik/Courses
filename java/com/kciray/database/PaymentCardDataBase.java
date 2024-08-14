package com.kciray.database;

import com.kciray.dao.CategoryDao;
import com.kciray.dao.PaymentCardDao;
import com.kciray.entity.PaymentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PaymentCardDataBase implements DataBase<Integer, PaymentCard>{


    private static PaymentCardDataBase paymentCardDataBase;
    private Map<Integer, PaymentCard> dataBaseMap = new HashMap<>();

    private PaymentCardDataBase() {
        add();
    }

    public static PaymentCardDataBase getInstance() {
        if (paymentCardDataBase == null) {
            paymentCardDataBase = new PaymentCardDataBase();
        }
        return paymentCardDataBase
                ;
    }

    private void add() {
        int id = 1;
        for (int i = 0; i < 20; i++) {
            dataBaseMap.put(id, PaymentCard.builder()
                            .id(id)
                            .cardHolder("Userbank - " + id)
                            .cardNumber("Card number " + id)
                            .expiryDate("Expiry Date " + id)
                            .cvv("12" + id)
                    .build());
            id++;
        }
    }


    @Override
    public Map<Integer,PaymentCard> getMapDataBase() {
        return dataBaseMap;
    }

    public PaymentCard addEntityDataBase(PaymentCard paymentCard) {
        Integer id = searсhLastElement();
        paymentCard.setId(id);
        dataBaseMap.put(id, paymentCard);
        return dataBaseMap.get(id);
    }
    private Integer searсhLastElement() {
        List<Integer> listKey = new ArrayList<>(dataBaseMap.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }
}
