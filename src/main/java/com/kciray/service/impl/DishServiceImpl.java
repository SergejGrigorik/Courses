package com.kciray.service.impl;

import com.kciray.repository.DishRepository;
import com.kciray.repository.impl.DishRepositoryImpl;
import com.kciray.dto.DishDto;
import com.kciray.model.menu.Dish;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends AbstractService<Integer,Dish,DishDto> implements BaseService<Integer,DishDto>, DishService {

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        super(Dish.class, DishDto.class, dishRepository);
    }

}

