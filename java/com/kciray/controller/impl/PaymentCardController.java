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

    }
}
