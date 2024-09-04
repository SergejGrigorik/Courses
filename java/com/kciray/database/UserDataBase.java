package com.kciray.database;

import com.kciray.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


public class UserDataBase implements DataBase<Integer, User> {
    private static UserDataBase userDataBase;
    private Map<Integer, User> userDataBaseMap = new HashMap<>();

    private GenerationId<User> generationId;

    private UserDataBase() {
    }

    public static UserDataBase getInstance() {
        if (userDataBase == null) {
            userDataBase = new UserDataBase();
        }
        return userDataBase;
    }


    @Override
    public Map<Integer, User> getMapDataBase() {
        return userDataBaseMap;
    }

    @Override
    public User getEntityFromDataBase(User value) {
        return generationId.addEntityDataBase(value, userDataBaseMap);
    }
}
