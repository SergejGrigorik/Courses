package com.kciray.mapper;

public interface ReadMapper<F,T>  {
    T toDto(F entity, Class<T> clazz);
}
