package com.kciray.service.impl;

import com.kciray.dto.DishDto;
import com.kciray.dto.entityfilter.DishFilter;
import com.kciray.model.menu.Dish;
import com.kciray.repository.DishRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl extends AbstractService<Integer, Dish, DishDto> implements BaseService<Integer, DishDto>, DishService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        super(Dish.class, DishDto.class, dishRepository);

    }

    @Override
    public List<DishDto> findAllBy(Pageable pageable) {
        List<Dish> allBy = dishRepository.findAllBy(pageable);
        return allBy.stream()
                .map(dish -> modelMapper.map(dish,DishDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<DishDto> findAllByFilter(DishFilter dishFilter) {
        return dishRepository.findAllByFilter(dishFilter)
                .stream().map(dish -> modelMapper.map(dish,DishDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<DishDto> findAllByRestaurantId(Integer restaurantId) {
//        return dishRepository.findAllByRestaurantId(restaurantId);
    return null;
    }

    @Override
    public List<DishDto> findAllDishByRestaurantIdAndCategoryById(Integer restId, Integer catId) {
        List<Dish> allDishByRestaurantIdAndCategoryById = dishRepository.findAllDishByRestaurantIdAndCategoryById(restId, catId);
        return allDishByRestaurantIdAndCategoryById.stream()
                .map(dish -> modelMapper.map(dish,DishDto.class)).collect(Collectors.toList());
    }

}

