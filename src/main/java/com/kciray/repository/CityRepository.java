package com.kciray.repository;

import com.kciray.model.address.City;

import java.util.List;

public interface CityRepository extends ApplicationRepository<Integer, City> {
    List<City> findByRegion(String regionName);
}
