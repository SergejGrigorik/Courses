package com.kciray.service.impl;

import com.kciray.dao.impl.CityDaoImpl;
import com.kciray.dto.CityDto;
import com.kciray.entity.address.City;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends AbstractService<City, CityDto> implements BaseService<Integer, CityDto>, CityService {

    @Autowired
    CityServiceImpl(CityDaoImpl dao) {
        super(City.class, CityDto.class, dao);
    }
}
