package com.kciray.service.impl;

import com.kciray.dao.impl.UserDaoImpl;
import com.kciray.dto.UserDto;
import com.kciray.entity.User;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl extends AbstractService<User, UserDto> implements BaseService<Integer, UserDto>, UserService {

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        super(User.class, UserDto.class, userDao);
    }

}


