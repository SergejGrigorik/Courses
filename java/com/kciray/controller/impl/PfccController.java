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
//        create(PfccDto.builder()
//                .id(62)
//                .proteins(163.123)
//                .fats(163.123)
//                .calories(163.123)
//                .carbohydrates(163.123)
//                .build());
//        create(PfccDto.builder()
//                .id(61)
//                .proteins(111.111)
//                .fats(111.111)
//                .calories(111.111)
//                .carbohydrates(111.111)
//                .build());
//        PfccDto pfccDto = findById(1);
//        pfccDto.setCalories(1111111111);
//        update(1, pfccDto);
//        findById(1);
        deleteById(62);

    }


}
