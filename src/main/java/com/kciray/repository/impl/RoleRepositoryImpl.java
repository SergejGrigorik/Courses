package com.kciray.repository.impl;

import com.kciray.model.Role;
import com.kciray.repository.RepositoryBase;
import com.kciray.repository.RoleRepository;

@org.springframework.stereotype.Repository
public class RoleRepositoryImpl extends RepositoryBase<Integer, Role> implements RoleRepository {

    public RoleRepositoryImpl() {
        super(Role.class);
    }
}
