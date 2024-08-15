package com.kciray.service;

import com.kciray.dao.RestaurantDao;
import com.kciray.dto.RestaurantDto;
import com.kciray.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService extends AbstractService<Restaurant,RestaurantDto> implements BaseService<Integer, RestaurantDto> {

    @Autowired
    public RestaurantService (RestaurantDao categoryDao) {
        super(Restaurant.class, RestaurantDto.class, categoryDao);
    }

}


















//    @Autowired
//    private Restaurant restaurant;
//    @Autowired
//    private ReadEntityMapper<Restaurant, RestaurantDto> readMapper;
//
//    @Autowired
//    private CreateEntityMapper<RestaurantDto, Restaurant> createdMapper;
//    @Autowired
//    private RestaurantDao restaurantDao;
//
//    public RestaurantDto create(RestaurantDto restaurantDto) {
//        Restaurant restaurantCardToSave = createdMapper.toEntity(restaurantDto, Restaurant.class);
//        Restaurant restaurantDtoCardFromSave = restaurantDao.save(restaurantCardToSave);
//        return readMapper.toDto(restaurantDtoCardFromSave,RestaurantDto.class);
//    }
//
//
//    public Optional<RestaurantDto> findById(Integer id) {
//        Optional<Restaurant> restaurant = restaurantDao.findById(id);
//        return Optional.ofNullable(readMapper.toDto(restaurant.orElseThrow(()->new RuntimeException(String.format("++Entity by id = %d does not exist", id))), RestaurantDto.class));
//    }
//
//    public List<RestaurantDto> findAll() {
//        List<Restaurant> categories = restaurantDao.findAll();
//        return categories.stream().map(entity -> readMapper.toDto(entity, RestaurantDto.class)).collect(Collectors.toList());
//    }
//
//    public boolean deleteById(Integer id) {
//        return restaurantDao.findById(id)
//                .map(entity -> {
//                    restaurantDao.delete(id);
//                    return true;
//                })
//                .orElse(false);
//    }
//
//    public Optional<RestaurantDto> update(Integer id, RestaurantDto restaurantDto) {
//        restaurantDao.update(id,createdMapper.toEntity(restaurantDto, Restaurant.class));
//        return findById(id);
//
//    }
//}
