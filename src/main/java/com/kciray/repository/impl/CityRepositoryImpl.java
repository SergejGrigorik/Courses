package com.kciray.repository.impl;


import com.kciray.dto.UserDto;
import com.kciray.model.QUser;
import com.kciray.model.User;
import com.kciray.repository.CityRepository;
import com.kciray.model.address.City;
import com.kciray.repository.RepositoryBase;

import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

@Repository

public class CityRepositoryImpl extends RepositoryBase<Integer,City>  implements CityRepository {
    public CityRepositoryImpl() {
        super(City.class);
    }

//    public User add(City city) {
//        return new JPAQuery<User>(entityManager)
//                .select(QUser.user);
//    }
}
