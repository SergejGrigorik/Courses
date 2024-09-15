package com.kciray.repository.impl;


import com.kciray.repository.RepositoryBase;
import com.kciray.repository.UserDao;
import com.kciray.model.User;

@org.springframework.stereotype.Repository
public class UserRepositoryImpl extends RepositoryBase<Integer, User> implements UserDao {


    public UserRepositoryImpl() {
        super(User.class);
    }
}
