package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.UserDao;
import com.kciray.database.UserDataBase;
import com.kciray.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    @Autowired
    public UserDaoImpl(UserDataBase db) {
        super(db);
    }
}
