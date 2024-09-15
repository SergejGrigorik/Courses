package com.kciray.repository.impl;


import com.kciray.repository.CityDao;
import com.kciray.model.address.City;
import com.kciray.repository.RepositoryBase;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository

public class CityRepositoryImpl extends RepositoryBase<Integer,City>  implements CityDao{
    public CityRepositoryImpl() {
        super(City.class);
    }
}
