package com.kciray.mapper.interfaceMapper;

public interface CourierMapper<F,T> {

    T map(F fromObject);
}
