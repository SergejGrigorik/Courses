package com.kciray.service.impl;


import com.kciray.repository.impl.CourierRepositoryImpl;
import com.kciray.dto.CourierDto;
import com.kciray.model.Courier;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transaction
public class CourierServiceImpl extends AbstractService<Integer,Courier, CourierDto> implements BaseService<Integer, CourierDto> , CategoryService {

    @Autowired
    public CourierServiceImpl(CourierRepositoryImpl courierDao) {
        super(Courier.class, CourierDto.class, courierDao);
    }

}

