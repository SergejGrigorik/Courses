package com.kciray.service;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.CityDao;
import com.kciray.dto.CityDto;
import com.kciray.entity.address.City;
import com.kciray.mapper.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService extends AbstractService<City, CityDto> implements BaseService<Integer, CityDto> {

@Autowired
    CityService(CityDao dao) {
        super(City.class, CityDto.class, dao);
    }
}
