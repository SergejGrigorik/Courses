package com.kciray.service.impl;

import com.kciray.repository.impl.PaymentCardRepositoryImpl;
import com.kciray.dto.PaymentCardDto;
import com.kciray.model.PaymentCard;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.PaymentCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentCardServiceImpl extends AbstractService<Integer,PaymentCard,PaymentCardDto> implements BaseService<Integer,PaymentCardDto>, PaymentCardService {

    @Autowired
    public PaymentCardServiceImpl(PaymentCardRepositoryImpl paymentCardDao) {
        super(PaymentCard.class, PaymentCardDto.class, paymentCardDao);
    }

}















