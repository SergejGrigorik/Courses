package com.kciray.database;

import com.kciray.entity.menu.Pfcc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class PfccDataBase implements  DataBase<Integer, Pfcc>{

    private static PfccDataBase pfccDataBase;
    private Map<Integer,Pfcc> dataBaseMap = new HashMap<>();
    @Autowired
    private GenerationId<Pfcc> generationId;

    private PfccDataBase (){
    }
    public static PfccDataBase getInstance(){
        if (pfccDataBase == null){
            pfccDataBase = new PfccDataBase();
        }
        return pfccDataBase;
    }


    @Override
    public Map<Integer, Pfcc> getMapDataBase() {
        return dataBaseMap;
    }

    @Override
    public Pfcc getEntityFromDataBase(Pfcc value) {

        return generationId.addEntityDataBase(value, dataBaseMap);
    }
}
