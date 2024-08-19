package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.*;
import com.kciray.entity.Role;
import com.kciray.entity.status.RoleEnum;
import com.kciray.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController extends Controllers<UserDto> implements ControllerInterfaceRun {
@Autowired
    public UserController(UserServiceImpl services) {
        super(services);
    }

    @Override
    public void crudDemo() {
        create(UserDto.builder()
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
                .build());

        create(UserDto.builder()
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
                .build());
        UserDto userDto = findById(1);
        userDto.setPassword(22222);


    }
}
