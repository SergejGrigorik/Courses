package com.kciray.service.impl;

import com.kciray.dto.address.CityDto;
import com.kciray.model.address.City;
import com.kciray.repository.CityRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends AbstractService<Integer, City, CityDto> implements CityService {

    @Autowired
    CityServiceImpl(CityRepository cityRepository) {
        super(City.class, CityDto.class, cityRepository);
    }
}
