package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.RegionDto;
import com.kciray.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegionController extends Controllers<RegionDto> implements ControllerInterfaceRun {

    @Autowired
    public RegionController(BaseService<Integer, RegionDto> services) {
        super(services);
    }

    @Override
    public void crudDemo() {
        create(RegionDto.builder()
                .id(1)
                .nameRegion("Grodno")
                .build());

        create(RegionDto.builder()
                .id(2)
                .nameRegion("Golinka")
                .build());
        RegionDto regionDto = findById(1);
        regionDto.setNameRegion("Nichego krome Grodno");
        update(1,regionDto);
        findById(1);
        deleteById(2);
    }
}
