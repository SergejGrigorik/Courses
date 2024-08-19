package com.kciray.service.impl;

import com.kciray.dao.impl.CourierDaoImpl;
import com.kciray.dto.CourierDto;
import com.kciray.entity.Courier;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierServiceImpl extends AbstractService<Courier, CourierDto> implements BaseService<Integer, CourierDto> , CategoryService {

    @Autowired
    public CourierServiceImpl(CourierDaoImpl courierDao) {
        super(Courier.class, CourierDto.class, courierDao);
    }

}

