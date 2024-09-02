package com.kciray.controller.impl;

import com.kciray.controller.ControllerInterfaceRun;
import com.kciray.controller.Controllers;
import com.kciray.dto.CategoryDto;
import com.kciray.dto.DishDto;
import com.kciray.dto.PfccDto;
import com.kciray.dto.RestaurantDto;
import com.kciray.service.BaseService;
import com.kciray.service.impl.DishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class DishController extends Controllers<DishDto> implements ControllerInterfaceRun {

@Autowired
    public DishController(BaseService<Integer,DishDto> services) {
        super(services);
    }

    @Override
    public void crudDemo() {
        create(DishDto.builder()
                .id(1)
                .name("Gamburger")
                .category(CategoryDto.builder()
                        .id(1)
                        .name("Burgers")
                        .build())
                .restaurant(RestaurantDto.builder()
                        .accountBank(2123123123)
                        .locationCoordinates("123x123")
                        .build())
                .price(BigDecimal.valueOf(1234))
                .weight(123.0)
                .pfcc(PfccDto.builder()
                        .proteins(97)
                        .fats(1)
                        .calories(1)
                        .carbohydrates(120)
                        .build())
                .description("The best Burger")
                .build());

        create(DishDto.builder()
                .id(2)
                .name("RazorviGenu")
                .category(CategoryDto.builder()
                        .id(2)
                        .name("Pizza")
                        .build())
                .restaurant(RestaurantDto.builder()
                        .accountBank(2123123123)
                        .locationCoordinates("123x123")
                        .build())
                .price(BigDecimal.valueOf(1234))
                .weight(123.0)
                .pfcc(PfccDto.builder()
                        .proteins(0)
                        .fats(40)
                        .calories(40)
                        .carbohydrates(120000000)
                        .build())
                .description("Gena loves this pizza ")
                .build());

        DishDto dto = findById(1);
        dto.setName("Chisburger");
        update(1,dto);
        findById(1);
        deleteById(1);
    }
}
