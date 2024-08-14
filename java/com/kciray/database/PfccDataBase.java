package com.kciray.database;

import com.kciray.entity.menu.Pfcc;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class PfccDataBase implements  DataBase<Integer, Pfcc>{

    private static PfccDataBase pfccDataBase;
    private Map<Integer,Pfcc> dataBaseMap = new HashMap<>();

    private PfccDataBase (){
    add();
    }
    public static PfccDataBase getInstance(){
        if (pfccDataBase == null){
            pfccDataBase = new PfccDataBase();
        }
        return pfccDataBase;
    }

    private void add(){
        int id = 1;
        for (int i = 0; i < 20 ; i++){
            dataBaseMap.put(id,Pfcc.builder()
                            .id(id)
                            .proteins(100 + id)
                            .fats(200 + id)
                            .calories(300 + id)
                            .carbohydrates(400 + id)
                    .build());
        }
    }

    @Override
    public Map<Integer, Pfcc> getMapDataBase() {
        return Map.of();
    }

    @Override
    public Pfcc addEntityDataBase(Pfcc value) {
        return null;
    }
}
