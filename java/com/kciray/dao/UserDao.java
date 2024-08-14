package com.kciray.dao;

import com.kciray.database.UserDataBase;
import com.kciray.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<User>{
    @Autowired
    public UserDao(UserDataBase db) {
        super(db);
    }
}
