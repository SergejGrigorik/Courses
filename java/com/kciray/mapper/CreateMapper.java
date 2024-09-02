package com.kciray.mapper;

public interface CreateMapper<F,T> {
    T toEntity(F entity, Class<T> clazz);

}
