package com.kciray.database;

import com.kciray.entity.PaymentCard;
import com.kciray.entity.Restaurant;
import com.kciray.entity.menu.Category;
import com.kciray.entity.menu.Dish;
import com.kciray.entity.menu.Pfcc;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DishDataBase implements DataBase<Integer, Dish> {
    private static DishDataBase dishDataBase;
    private Map<Integer, Dish> dishDataBaseMap = new HashMap<>();

    private DishDataBase() {
        add();
    }

    public static DishDataBase getInstance() {
        if (dishDataBase == null) {
            dishDataBase = new DishDataBase();
        }
        return dishDataBase;
    }

    private void add() {
        RestaurantDataBase restaurantDataBase = RestaurantDataBase.getInstance();
        int id = 1;
        for (int i = 0; i < 20; i++) {

            dishDataBaseMap.put(id, Dish.builder()
                            .id(id)
                            .name("burger - " + id)
                            .category(Category.builder().build())
                            .restaurant(restaurantDataBase.getMapDataBase().get(id))
                            .price(BigDecimal.valueOf(1000 + id))
                            .weight(100.0 + id)
                            .pfcc(Pfcc.builder().build())
                            .description("perfect")
                    .build());
            id++;
        }
    }

    @Override
    public Map<Integer, Dish> getMapDataBase() {
        return dishDataBaseMap;
    }

    @Override
    public Dish addEntityDataBase(Dish dish) {
        Integer id = searсhLastElement();
        dish.setId(id);
        dishDataBaseMap.put(id, dish);
        return dishDataBaseMap.get(id);
    }
    private Integer searсhLastElement() {
        List<Integer> listKey = new ArrayList<>(dishDataBaseMap.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }
}
