package com.kciray.service.impl;

import com.kciray.dto.address.CityDto;
import com.kciray.model.address.City;
import com.kciray.repository.CityRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl extends AbstractService<Integer, City, CityDto> implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    CityServiceImpl(CityRepository cityRepository) {
        super(City.class, CityDto.class, cityRepository);
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDto> findByRegionName(String regionName) {
        List<City> byRegion = cityRepository.findByRegion(regionName);
        return byRegion.stream().map(city -> modelMapper.map(city, CityDto.class)).collect(Collectors.toList());
    }
}
