package com.kciray.database;

import com.kciray.entity.address.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Component
public class CityDabase implements DataBase<Integer , City>{
    Map<Integer, City> cityDataBase = new HashMap<Integer, City>();
    private static CityDabase instance ;

    private CityDabase(){
    }

    public static CityDabase getInstance(){
        if(instance == null){
            instance = new CityDabase();
        }
        return instance;
    }

    @Override
    public Map<Integer, City> getMapDataBase() {
        return cityDataBase;
    }

    @Override
    public City addEntityDataBase(City value) {
        if (value.getId() == 0) {
            Integer id = searсhLastElement();
            value.setId(id);
            cityDataBase.put(id, value);
            return cityDataBase.get(id);
        } else {
            cityDataBase.put(value.getId(), value);
        }
        return cityDataBase.get(value.getId());
    }

    private Integer searсhLastElement() {
        List<Integer> listKey = new ArrayList<>(cityDataBase.keySet());
        List<Integer> listSortKey = listKey.stream().sorted().collect(Collectors.toList());
        Integer lastElement = listSortKey.get(listSortKey.size() - 1);
        return ++lastElement;
    }
}
