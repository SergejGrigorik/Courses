package com.kciray.service.impl;

import com.kciray.dao.impl.PaymentCardDaoImpl;
import com.kciray.dto.PaymentCardDto;
import com.kciray.entity.PaymentCard;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.PaymentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentCardServiceImpl extends AbstractService<Integer,PaymentCard,PaymentCardDto> implements BaseService<Integer,PaymentCardDto>, PaymentCardService {

    @Autowired
    public PaymentCardServiceImpl(PaymentCardDaoImpl paymentCardDao) {
        super(PaymentCard.class, PaymentCardDto.class, paymentCardDao);
    }

}















