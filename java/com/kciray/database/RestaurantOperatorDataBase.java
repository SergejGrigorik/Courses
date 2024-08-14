package com.kciray.database;

import com.kciray.dao.CategoryDao;
import com.kciray.dao.RestaurantOperatorDao;
import com.kciray.entity.Courier;
import com.kciray.entity.PaymentCard;
import com.kciray.entity.RestaurantOperator;
import com.kciray.entity.User;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.kciray.entity.status.RoleEnum.ADMINISTRATOR;
import static com.kciray.entity.status.RoleEnum.COURIER;
@Component
public class RestaurantOperatorDataBase implements DataBase<Integer, RestaurantOperator> {

    private static RestaurantOperatorDataBase restaurantOperatorDataBase;
    private Map<Integer, RestaurantOperator> restaurantOperatorDataBaseMap = new HashMap<>();

    private RestaurantOperatorDataBase() {
        add();

    }
    public static RestaurantOperatorDataBase getInstance(){
        if(restaurantOperatorDataBase==null){
            restaurantOperatorDataBase = new RestaurantOperatorDataBase();
        }
        return restaurantOperatorDataBase;
    }

    private  void add() {
        UserDataBase userDataBase = UserDataBase.getInstance();
        RestaurantDataBase restaurantDataBase = RestaurantDataBase.getInstance();
        List<User> collect = userDataBase.getUserDataBaseMap().values().stream().filter(s -> s.getRole().getRole().equals(ADMINISTRATOR)).collect(Collectors.toList());
        int size = collect.size();
        int id = 1;
        int idUser = 1;
        while ( size > 1 ){
            restaurantOperatorDataBaseMap.put(id,RestaurantOperator.builder()
                            .id(id)
                            .restaurant(restaurantDataBase.getMapDataBase().get(id))
                            .user(collect.get(idUser))
                    .build());
            idUser++;
            size--;
            id++;
        }
    }

    @Override
    public Map<Integer, RestaurantOperator> getMapDataBase() {
        return restaurantOperatorDataBaseMap;
    }

    @Override
    public RestaurantOperator addEntityDataBase(RestaurantOperator value) {
        Integer id = searсhLastElement();
        value.setId(id);
        restaurantOperatorDataBaseMap.put(id, value);
        return restaurantOperatorDataBaseMap.get(id);
    }
    private Integer searсhLastElement() {
        List<Integer> listKey = new ArrayList<>(restaurantOperatorDataBaseMap.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }
}
