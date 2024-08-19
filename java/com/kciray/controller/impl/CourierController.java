package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.*;
import com.kciray.entity.Role;
import com.kciray.entity.status.CourierStatus;
import com.kciray.entity.status.RoleEnum;
import com.kciray.service.impl.CourierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CourierController extends Controllers<CourierDto> implements ControllerInterfaceRun {
    @Autowired
    public CourierServiceImpl courierService;

    public CourierController(CourierServiceImpl courierService) {
        super(courierService);
    }


    @Override
    public void crudDemo() {
        create(CourierDto.builder()
                .id(21)
                .locationCoordinates("222x222")
                .courierStatus(CourierStatus.BUSY)
                .user(UserDto.builder()
                        .id((1))
                        .profile(ProfileDto.builder()
                                .id(1)
                                .firstName("Igor")
                                .lastName("Smolka")
                                .number(123123113)
                                .address(AddressDto.builder()
                                        .id(1)
                                        .city(CityDto.builder()
                                                .id(1)
                                                .region(RegionDto.builder()
//                                                        .id(1)
                                                        .nameRegion("Grodno")
                                                        .build())
                                                .nameCity("Grodno")
                                                .build())
                                        .street("Kabjaka")
                                        .house("37")
                                        .apartment(" ?")
                                        .build())
                                .build())
                        .password(1111)
                        .login("123123")
                        .role(Role.builder()
                                .id(1)
                                .role(RoleEnum.COURIER)
                                .build())
                        .build())

                .build());


        create(CourierDto.builder()
                .id(22)

                .courierStatus(CourierStatus.BUSY)
                .user(UserDto.builder()
                        .id((2))
                        .profile(ProfileDto.builder()
                                .id(2)
                                .firstName("Vitalik")
                                .lastName("Gorodok")
                                .number(324242234)
                                .address(AddressDto.builder()
                                        .id(2)
                                        .city(CityDto.builder()
                                                .id(2)
                                                .region(RegionDto.builder()
//                                                       .id(2)
                                                        .nameRegion("Grodno")
                                                        .build())
                                                .nameCity("Grodno")
                                                .build())
                                        .street("Davatora")
                                        .house("21")
                                        .apartment("18")
                                        .build())
                                .build())
                        .password(1111)
                        .login("123123")
                        .role(Role.builder()
                                .id(1)
                                .role(RoleEnum.COURIER)
                                .build())
                        .build())
                .locationCoordinates("222x11111111111")
                .build());
        CourierDto courierDto = findById(22);
        courierDto.setCourierStatus(CourierStatus.WEEKEND);
        courierDto.setLocationCoordinates("11111x11111111");
        update(22, courierDto);
        findById(22);
        deleteById(21);
    }
}
