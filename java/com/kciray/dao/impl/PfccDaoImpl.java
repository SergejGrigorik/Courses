package com.kciray.dao.impl;

import com.kciray.dao.AbstractDao;
import com.kciray.dao.PfccDao;
import com.kciray.database.PfccDataBase;
import com.kciray.entity.menu.Pfcc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PfccDaoImpl extends AbstractDao<Pfcc> implements PfccDao {
    @Autowired
    public PfccDaoImpl(PfccDataBase db) {
        super(db);
    }
}
