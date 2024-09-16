package com.kciray.repository.impl;


import com.kciray.repository.RepositoryBase;
import com.kciray.repository.UserRepository;
import com.kciray.model.User;

@org.springframework.stereotype.Repository
public class UserRepositoryImpl extends RepositoryBase<Integer, User> implements UserRepository {


    public UserRepositoryImpl() {
        super(User.class);
    }
}
