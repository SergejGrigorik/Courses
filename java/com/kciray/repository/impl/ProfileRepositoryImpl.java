package com.kciray.repository.impl;

import com.kciray.repository.ProfileDao;
import com.kciray.model.Profile;
import com.kciray.repository.RepositoryBase;

@org.springframework.stereotype.Repository
public class ProfileRepositoryImpl extends RepositoryBase<Integer,Profile> implements ProfileDao{


    public ProfileRepositoryImpl() {
        super(Profile.class);
    }
}
