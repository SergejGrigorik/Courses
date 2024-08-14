package com.kciray.database;

import com.kciray.entity.PaymentCard;
import com.kciray.entity.RestaurantChain;
import lombok.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Value
public class RestaurantChainDataBase  implements DataBase<Integer, RestaurantChain>{

    private static RestaurantChainDataBase restaurantChainDataBase;
    Map<Integer, RestaurantChain> restaurantDataBaseMap = new HashMap<>();

    private RestaurantChainDataBase(){
        add();
    }

    public static RestaurantChainDataBase getInstance() {
        if (restaurantChainDataBase == null) {
            restaurantChainDataBase = new RestaurantChainDataBase();
        }
        return restaurantChainDataBase;
    }

    private void add() {
        int id = 1;
        for (int i = 0; i < 20; i++) {
            restaurantDataBaseMap.put(id, RestaurantChain.builder()
                    .id(id)
                    .name("restaurant - " + id)
                    .build());
            id++;
        }
    }

    @Override
    public Map<Integer, RestaurantChain> getMapDataBase() {
        return restaurantDataBaseMap;
    }

    @Override
    public RestaurantChain addEntityDataBase(RestaurantChain value) {
        Integer id = searсhLastElement();
        value.setId(id);
        restaurantDataBaseMap.put(id, value);
        return restaurantDataBaseMap.get(id);
    }
    private Integer searсhLastElement() {
        List<Integer> listKey = new ArrayList<>(restaurantDataBaseMap.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }
}
