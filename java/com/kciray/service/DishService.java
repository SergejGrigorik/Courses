package com.kciray.service;

import com.kciray.dao.DishDao;
import com.kciray.dto.DishDto;
import com.kciray.entity.menu.Dish;
import com.kciray.mapper.CreateEntityMapper;
import com.kciray.mapper.ReadEntityMapper;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class DishService implements Services<Integer,DishDto> {
    @Autowired
    private DishDao dishDao;
    @Autowired
    private ReadEntityMapper<Dish, DishDto>  readMapper;

    @Autowired
    private CreateEntityMapper<DishDto, Dish> createdMapper;

    public DishDto create(DishDto dishDto) {
        Dish dishToSave = createdMapper.toEntity(dishDto, Dish.class);
        Dish dishFromSave = dishDao.save(dishToSave);
        return readMapper.toDto(dishFromSave,DishDto.class);
    }


    public Optional<DishDto> findById(Integer id) {
        Optional<Dish> dish = dishDao.findById(id);
        return Optional.ofNullable(readMapper.toDto(dish.orElseThrow(()-> new RuntimeException(String.format("Entity by id = %d does not exist", id))), DishDto.class));
    }

    public List<DishDto> findAll() {
        List<Dish> dishes = dishDao.findAll();
        return dishes.stream().map(entity -> readMapper.toDto(entity, DishDto.class)).collect(Collectors.toList());
    }

    public boolean deleteById(Integer id) {
        return dishDao.findById(id)
                .map(entity -> {
                    dishDao.delete(id);
                    return true;
                })
                .orElse(false);
    }

    public Optional<DishDto> update(Integer id, DishDto dishDto) {
        dishDao.update(id,createdMapper.toEntity(dishDto, Dish.class));
        return findById(id);

    }

}
