package com.kciray.controller;

import com.kciray.dto.*;
import com.kciray.entity.Profile;
import com.kciray.entity.Role;
import com.kciray.entity.status.CourierStatus;
import com.kciray.entity.status.RoleEnum;
import com.kciray.service.BaseService;
import com.kciray.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CourierController extends Controllers<CourierDto> implements ControllerInterfaceRun{
    @Autowired
    public CourierService courierService;

    public CourierController(BaseService<Integer, CourierDto> services) {
        super(services);
    }




    @Override
    public void crud() {
        create(CourierDto.builder()
                .id(21)
                .locationCoordinates("222x222")
                .courierStatus(CourierStatus.BUSY)
                .userDto(UserDto.builder()
                        .id((1))
                        .profile(ProfileDto.builder()
                                .id(1)
                                .firstName("Gena")
                                .lastName("Gorodok")
                .number(123123113)
                                .address(AddressDto.builder()
                                        .id(1)
                                        .city(CityDto.builder()
                                                .id(1)
                                                .region(RegionDto.builder()
                                                        .id(1)
                                                        .nameRegion("Grodno")
                                                        .build())
                                                .nameCity("Grodno")
                                                .build())
                                        .street("Puchkova")
                                        .house("41")
                                        .apartment("23")
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
                .locationCoordinates("222x222")
                .courierStatus(CourierStatus.BUSY)
                .userDto(UserDto.builder()
                        .id((2))
                        .profile(ProfileDto.builder()
                                .id(2)
                                .firstName("Gena")
                                .lastName("Gorodok")
                                .number(123123113)
                                .address(AddressDto.builder()
                                        .id(2)
                                        .city(CityDto.builder()
                                                .id(2)
                                                .region(RegionDto.builder()
                                                        .id(2)
                                                        .nameRegion("Grodno")
                                                        .build())
                                                .nameCity("Grodno")
                                                .build())
                                        .street("Puchkova")
                                        .house("41")
                                        .apartment("23")
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
        CourierDto courierDto =findById(22);
        courierDto.setCourierStatus(CourierStatus.WEEKEND);
        courierDto.setLocationCoordinates("11111111111111");
        update(22,courierDto);
        findById(22);
        deleteById(21);
    }
}
