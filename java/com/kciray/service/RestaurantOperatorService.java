package com.kciray.service;

import com.kciray.dao.RestaurantOperatorDao;
import com.kciray.dto.RestaurantOperatorDto;
import com.kciray.entity.RestaurantOperator;
import com.kciray.mapper.CreateEntityMapper;
import com.kciray.mapper.ReadEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class RestaurantOperatorService implements Services<Integer,RestaurantOperatorDto> {
    @Autowired
    private RestaurantOperatorDao restaurantOperatorDao;
    @Autowired
    private ReadEntityMapper<RestaurantOperator, RestaurantOperatorDto> readMapper;

    @Autowired
    private CreateEntityMapper<RestaurantOperatorDto, RestaurantOperator> createdMapper;

    public RestaurantOperatorDto create(RestaurantOperatorDto restaurantOperatorDto) {
        RestaurantOperator restaurantOperatorToSave = createdMapper.toEntity(restaurantOperatorDto, RestaurantOperator.class);
        RestaurantOperator restaurantOperatorFromSave = restaurantOperatorDao.save(restaurantOperatorToSave);
        return readMapper.toDto(restaurantOperatorFromSave,RestaurantOperatorDto.class);
    }


    public Optional<RestaurantOperatorDto> findById(Integer id) {
        Optional<RestaurantOperator> category = restaurantOperatorDao.findById(id);
        return Optional.ofNullable(readMapper.toDto(category.orElseThrow(()->new RuntimeException(String.format("++Entity by id = %d does not exist", id))), RestaurantOperatorDto.class));
    }

    public List<RestaurantOperatorDto> findAll() {
        List<RestaurantOperator> categories = restaurantOperatorDao.findAll();
        return categories.stream().map(entity -> readMapper.toDto(entity, RestaurantOperatorDto.class)).collect(Collectors.toList());
    }

    public boolean deleteById(Integer id) {
        return restaurantOperatorDao.findById(id)
                .map(entity -> {
                    restaurantOperatorDao.delete(id);
                    return true;
                })
                .orElse(false);
    }

    public Optional<RestaurantOperatorDto> update(Integer id, RestaurantOperatorDto restaurantOperatorDto) {
        restaurantOperatorDao.update(id,createdMapper.toEntity(restaurantOperatorDto, RestaurantOperator.class));
        return findById(id);

    }

}

