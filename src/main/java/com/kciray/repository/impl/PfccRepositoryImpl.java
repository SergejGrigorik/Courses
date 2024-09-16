package com.kciray.repository.impl;


import com.kciray.repository.PfccRepository;
import com.kciray.model.menu.Pfcc;
import com.kciray.repository.RepositoryBase;

@org.springframework.stereotype.Repository
public class PfccRepositoryImpl extends RepositoryBase<Integer, Pfcc> implements PfccRepository {
    public PfccRepositoryImpl() {
        super(Pfcc.class);
    }
}
