package com.kciray.database;

import com.kciray.dao.RestaurantDao;
import com.kciray.entity.PaymentCard;
import com.kciray.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RestaurantDataBase implements DataBase<Integer, Restaurant> {
    private static RestaurantDataBase restaurantDataBase;
    RestaurantDao restaurantDao;
    private Map<Integer, Restaurant> restaurantDataBaseDataBaseMap = new HashMap<>();

    private RestaurantDataBase() {
        add();

    }

    public static RestaurantDataBase getInstance() {
        if (restaurantDataBase == null) {
            restaurantDataBase = new RestaurantDataBase();
        }
        return restaurantDataBase;
    }


    private void add() {
        int id = 1;
        RestaurantChainDataBase restaurantChainDataBase = RestaurantChainDataBase.getInstance();
        for (int i = 0; i < 20; i++) {
            restaurantDataBaseDataBaseMap.put(id, Restaurant.builder()
                    .id(id)
                    .restaurantChain(restaurantChainDataBase.getRestaurantDataBaseMap().get(id))
                    .accountBank(11111 + id)
                    .locationCoordinates("123x123")
                    .build());
            id++;

        }
    }



    @Override
    public Map<Integer, Restaurant> getMapDataBase() {
        return restaurantDataBaseDataBaseMap;
    }

    @Override
    public Restaurant addEntityDataBase(Restaurant value) {
        Integer id = searсhLastElement();
        value.setId(id);
        restaurantDataBaseDataBaseMap.put(id, value);
        return restaurantDataBaseDataBaseMap.get(id);
    }
    private Integer searсhLastElement() {
        List<Integer> listKey = new ArrayList<>(restaurantDataBaseDataBaseMap.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }
}
