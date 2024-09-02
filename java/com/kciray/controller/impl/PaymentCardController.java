package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.PaymentCardDto;
import com.kciray.service.BaseService;
import com.kciray.service.impl.PaymentCardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentCardController extends Controllers<PaymentCardDto> implements ControllerInterfaceRun {
    @Autowired
    public PaymentCardController(BaseService<Integer,PaymentCardDto> services) {
        super(services);
    }

    @Override
    public void crudDemo() {
        create(PaymentCardDto.builder()
                .cardHolder("Gena Gorodok")
                .cardNumber("1234-1243-1244-1244")
                .expiryDate("27.02.2030")
                .cvv("123")
                .build());

        create(PaymentCardDto.builder()
                .cardHolder("Dima Latosh")
                .cardNumber("1234-1243-1244-1244")
                .expiryDate("11.02.2029")
                .cvv("231")
                .build());
        PaymentCardDto paymentCardDto = findById(1);
        paymentCardDto.setCardHolder("0000-0000-0000-0000");
        update(1,paymentCardDto);
        findById(1);
        deleteById(2);

    }
}
