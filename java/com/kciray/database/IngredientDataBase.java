package com.kciray.database;

import com.kciray.entity.PaymentCard;
import com.kciray.entity.menu.Ingredient;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class IngredientDataBase  implements DataBase<Integer,Ingredient>{
    private static IngredientDataBase ingredientDataBase;
    private Map<Integer, Ingredient> ingredientDataBaseMap = new HashMap<>();

    private IngredientDataBase() {
        add();
    }

    public static IngredientDataBase getInstance() {
        if (ingredientDataBase == null) {
            ingredientDataBase = new IngredientDataBase();
        }
        return ingredientDataBase;
    }

    private void add() {
        int id = 1;
        for (int i = 0; i < 20; i++) {
            ingredientDataBaseMap.put(id,Ingredient.builder()
                            .id(id)
                            .name("Ingredient - " + id)
                            .weigth(1000.0 + id)
                            .price(BigDecimal.valueOf(1000 + id))
                    .build());
        }
    }

    @Override
    public Map<Integer, Ingredient> getMapDataBase() {
        return ingredientDataBaseMap;
    }

    @Override
    public Ingredient addEntityDataBase(Ingredient value) {
        Integer id = searсhLastElement();
        value.setId(id);
        ingredientDataBaseMap.put(id, value);
        return ingredientDataBaseMap.get(id);
    }
    private Integer searсhLastElement() {
        List<Integer> listKey = new ArrayList<>(ingredientDataBaseMap.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }

    // id рестораны нет или dish
}
