package com.kciray.service;

import com.kciray.dao.UserDao;
import com.kciray.dto.UserDto;
import com.kciray.entity.User;
import com.kciray.mapper.CreateEntityMapper;
import com.kciray.mapper.ReadEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service

public class UserService implements Services<Integer,UserDto> {

    @Autowired
    private ReadEntityMapper<User, UserDto> readMapper;

    @Autowired
    private CreateEntityMapper<UserDto, User> createdMapper;
    @Autowired
    private UserDao userDao;

    public UserDto create(UserDto userDto) {
        User userCardToSave = createdMapper.toEntity(userDto, User.class);
        User userCardFromSave = userDao.save(userCardToSave);
        return readMapper.toDto(userCardFromSave,UserDto.class);
    }


    public Optional<UserDto> findById(Integer id) {
        Optional<User> user = userDao.findById(id);
        return Optional.ofNullable(readMapper.toDto(user.orElseThrow(()->new RuntimeException(String.format("++Entity by id = %d does not exist", id))), UserDto.class));
    }

    public List<UserDto> findAll() {
        List<User> categories = userDao.findAll();
        return categories.stream().map(entity -> readMapper.toDto(entity, UserDto.class)).collect(Collectors.toList());
    }

    public boolean deleteById(Integer id) {
        return userDao.findById(id)
                .map(entity -> {
                    userDao.delete(id);
                    return true;
                })
                .orElse(false);
    }

    public Optional<UserDto> update(Integer id, UserDto userDto) {
        userDao.update(id,createdMapper.toEntity(userDto, User.class));
        return findById(id);

    }

}

