package com.kciray.repository.impl;

import com.kciray.repository.ProfileRepository;
import com.kciray.model.Profile;
import com.kciray.repository.RepositoryBase;

@org.springframework.stereotype.Repository
public class ProfileRepositoryImpl extends RepositoryBase<Integer,Profile> implements ProfileRepository {

    public ProfileRepositoryImpl() {
        super(Profile.class);
    }
}
