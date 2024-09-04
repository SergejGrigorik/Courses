package com.kciray.service.impl;

import com.kciray.annotation.Transaction;
import com.kciray.connection.ConnectionPool;
import com.kciray.dao.impl.UserDaoImpl;
import com.kciray.dto.UserDto;
import com.kciray.entity.User;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
//@Transaction
public class UserServiceImpl extends AbstractService<Integer, User, UserDto> implements BaseService<Integer, UserDto>, UserService {


    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        super(User.class, UserDto.class, userDao);

    }

    public UserServiceImpl() {
    }



    @Transaction
    @Override
    public Optional<UserDto> findById(Integer id) {
        Optional<User> category = entityDao.findById(id);
        return Optional.ofNullable(modelMapper.map(category.orElseThrow(() -> new RuntimeException(String.format("Entity by id = %d does not exist", id))), entityDtoClass));
    }

}


