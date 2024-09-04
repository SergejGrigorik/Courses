package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.*;
import com.kciray.entity.Role;
import com.kciray.entity.status.RoleEnum;
import com.kciray.service.BaseService;
import com.kciray.service.impl.RestaurantOperatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RestaurantOperatorController extends Controllers<RestaurantOperatorDto> implements ControllerInterfaceRun {
    @Autowired
    public RestaurantOperatorController(BaseService<Integer,RestaurantOperatorDto> services) {
        super(services);
    }

    @Override
    public void crudDemo() {
//        create(RestaurantOperatorDto.builder()
//                .id(1)
//                .restaurant(RestaurantDto.builder()
//                        .accountBank(435352)
//                        .locationCoordinates("234234")
//                        .build())
//                .user(UserDto.builder()
//                        .id(1)
//                        .profile(ProfileDto.builder()
//                                .id(1)
//                                .firstName("Igor")
//                                .lastName("Smolka")
//                                .number(123123113)
//                                .address(AddressDto.builder()
//                                        .id(1)
//                                        .city(CityDto.builder()
//                                                .id(1)
//                                                .region(RegionDto.builder()
//                                                        .id(1)
//                                                        .nameRegion("Grodno")
//                                                        .build())
//                                                .nameCity("Grodno")
//                                                .build())
//                                        .street("Kabjaka")
//                                        .house("37")
//                                        .apartment(" ?")
//                                        .build())
//                                .build())
//                        .password(1111)
//                        .login("123123")
//                        .role(Role.builder()
//                                .id(1)
//                                .role(RoleEnum.ADMINISTRATOR)
//                                .build())
//                        .build())
//
//                .build());
//
//
//        create(RestaurantOperatorDto.builder()
//                .id(2)
//                .restaurant(RestaurantDto.builder()
//                        .accountBank(000005)
//                        .locationCoordinates("234x34")
//                        .build())
//                .user(UserDto.builder()
//                        .id(2)
//                        .profile(ProfileDto.builder()
//                                .id(1)
//                                .firstName("Jenja")
//                                .lastName("Odnorukij")
//                                .number(11111113)
//                                .address(AddressDto.builder()
//                                        .id(2)
//                                        .city(CityDto.builder()
//                                                .id(2)
//                                                .region(RegionDto.builder()
//                                                        .id(2)
//                                                        .nameRegion("Grodno")
//                                                        .build())
//                                                .nameCity("Golynka")
//                                                .build())
//                                        .street("Olshanka")
//                                        .house("25")
//                                        .apartment("34")
//                                        .build())
//                                .build())
//                        .password(3333)
//                        .login("444444")
//                        .role(Role.builder()
//                                .id(2)
//                                .role(RoleEnum.ADMINISTRATOR)
//                                .build())
//                        .build())
//
//                .build());
//
//        RestaurantOperatorDto restaurantOperatorDto = findById(1);
//        restaurantOperatorDto.setId(2222);
//        update(1, restaurantOperatorDto);
//        findById(1);
//        deleteById(2);
    }
}
