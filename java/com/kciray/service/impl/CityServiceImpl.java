package com.kciray.service.impl;

import com.kciray.repository.impl.CityRepositoryImpl;
import com.kciray.dto.CityDto;
import com.kciray.model.address.City;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends AbstractService<Integer,City, CityDto> implements BaseService<Integer, CityDto>, CityService {

    @Autowired
    CityServiceImpl(CityRepositoryImpl dao) {
        super(City.class, CityDto.class, dao);
    }
}
