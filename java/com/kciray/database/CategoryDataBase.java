package com.kciray.database;

import com.kciray.entity.menu.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CategoryDataBase implements DataBase<Integer, Category> {
    private static CategoryDataBase instance;
    Map<Integer, Category> categoryMap = new HashMap<Integer, Category>();


    private CategoryDataBase() {
        add();

    }

    public static CategoryDataBase getInstance() {
        if (instance == null) {
            instance = new CategoryDataBase();
        }
        return instance;
    }

    private void add() {
        int id = 1;
        for (int i = 0; i < 20; i++) {
            categoryMap.put(id, Category.builder()
                    .id(id)
                    .name("Category - " + id)
                    .build());
        }
        id++;
    }


    @Override
    public Map<Integer, Category> getMapDataBase() {
        return categoryMap;
    }

    @Override
    public Category addEntityDataBase(Category category) {
        if (category.getId() == 0) {
            Integer id = searсhLastElement();
            category.setId(id);
            categoryMap.put(id, category);
            return categoryMap.get(id);
        } else {
            categoryMap.put(category.getId(), category);
        }
        return categoryMap.get(category.getId());
    }

    private Integer searсhLastElement() {
        List<Integer> listKey = new ArrayList<>(categoryMap.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }
}
