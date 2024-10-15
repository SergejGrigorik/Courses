package com.kciray.service;

import com.kciray.dto.address.CityDto;

import java.util.List;

public interface CityService extends BaseService<Integer, CityDto> {

    List<CityDto> findByRegionName(String regionName);
}
