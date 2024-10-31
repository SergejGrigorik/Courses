package com.kciray.repository.impl;

import com.kciray.model.address.City;
import com.kciray.repository.CityRepository;
import com.kciray.repository.RepositoryBase;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.kciray.model.address.QCity.city;
import static com.kciray.model.address.QRegion.region;

@Repository
public class CityRepositoryImpl extends RepositoryBase<Integer, City> implements CityRepository {
    public CityRepositoryImpl() {
        super(City.class);
    }

    @Override
    public List<City> findAll() {
        return new JPAQuery<City>(entityManager)
                .select(city)
                .from(city)
                .fetch();
    }

    @Override
    public Optional<City> findById(Integer id) {
        return Optional.ofNullable(new JPAQuery<City>(entityManager)
                .select(city)
                .from(city)
                .where(city.id.eq(id))
                .fetchOne());
    }

    public List<City> findByRegion(String regionName) {
        return new JPAQuery<City>(entityManager)
                .select(city)
                .from(region)
                .join(region.city, city)
                .where(region.nameRegion.eq(regionName))
                .orderBy(city.id.asc())
                .fetch();
    }

}

