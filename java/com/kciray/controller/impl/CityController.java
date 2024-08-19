package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.CityDto;
import com.kciray.dto.RegionDto;
import com.kciray.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController extends Controllers<CityDto> implements ControllerInterfaceRun {
    @Autowired
    CityServiceImpl cityService ;

    public CityController(CityServiceImpl cityService) {
        super(cityService);
    }

    @Override
    public void crudDemo() {
        create(CityDto.builder()
                .id(1)
                .region(RegionDto.builder()
                        .id(1)
                        .nameRegion("grodno region")
                        .build())
                .nameCity("Golynochka")
                .build());
        create(CityDto.builder()
                .id(2)
                .region(RegionDto.builder()
                        .id(2)
                        .nameRegion("grodno region")
                        .build())
                .nameCity("Grodno")
                .build());
        CityDto cityDto = findById(1);
        cityDto.setNameCity("Tolko Groooooooooooodno ");
        update(1,cityDto);
        findById(1);
        deleteById(1);

    }
}

//{"id":1,"region":{"id":1,"nameRegion":"grodno region"},"nameCity":"Grodno"}