package com.kciray.mapper.interfaceMapper;

public interface UserMapper<F,T> {
        T map(F object);
}
