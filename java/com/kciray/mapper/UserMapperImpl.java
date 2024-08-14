package com.kciray.mapper;

import com.kciray.dto.UserDto;
import com.kciray.entity.User;
import com.kciray.mapper.interfaceMapper.UserMapper;

public class UserMapperImpl implements UserMapper<User, UserDto> {
    @Override
    public UserDto map(User object) {
        return new UserDto(
                object.getPassword(),
                object.getLogin(),
                object.getRole()
        );
    }
}
