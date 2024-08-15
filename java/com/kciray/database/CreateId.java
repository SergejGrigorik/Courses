package com.kciray.database;

import com.kciray.entity.BaseEntity;
import com.kciray.entity.menu.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Component
public class CreateId<T extends BaseEntity<Integer>> {


    public T addEntityDataBase(T entity, Map<Integer,T> mapDataBase) {

        if (entity.getId() == 0) {
            Integer id = searсhLastElement(mapDataBase);
            entity.setId(id);
            mapDataBase.put(id, entity);
            return mapDataBase.get(id);
        } else {
            mapDataBase.put(entity.getId(), entity);
        }
        return mapDataBase.get(entity.getId());
    }

    private Integer searсhLastElement(Map<Integer, T> mapDataBase) {
        List<Integer> listKey = new ArrayList<>(mapDataBase.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }
}
