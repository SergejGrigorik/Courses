package com.kciray.service.impl;

import com.kciray.dao.impl.DishDaoImpl;
import com.kciray.dto.DishDto;
import com.kciray.entity.menu.Dish;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends AbstractService<Dish,DishDto> implements BaseService<Integer,DishDto>, DishService {

    @Autowired
    public DishServiceImpl(DishDaoImpl dishDao) {
        super(Dish.class, DishDto.class, dishDao);
    }

}

