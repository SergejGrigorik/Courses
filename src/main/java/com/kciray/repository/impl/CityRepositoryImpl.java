package com.kciray.repository.impl;

import com.kciray.model.address.City;
import com.kciray.repository.CityRepository;
import com.kciray.repository.RepositoryBase;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepositoryImpl extends RepositoryBase<Integer, City> implements CityRepository {
    public CityRepositoryImpl() {
        super(City.class);
    }

}
