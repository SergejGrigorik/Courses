package com.kciray.controller.impl;


import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.PfccDto;
import com.kciray.service.BaseService;
import com.kciray.service.impl.PfccServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class PfccController extends Controllers<PfccDto> implements ControllerInterfaceRun {
//    @Autowired
//    private BaseService<Integer, PfccDto> services ;

//    PfccController() {
//        super(services);
//    }
//
//    @Autowired
//    public PfccController(PfccServiceImpl services) {
//        super(services);
//    }

    @Autowired
    public PfccController(BaseService<Integer, PfccDto> services) {
        super(services);
    }

    //    BaseService<Integer, PfccDto>
    @Override
    public void crudDemo() {

    }


}
