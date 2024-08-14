package com.kciray.dao;

import com.kciray.database.DataBase;
import com.kciray.database.PfccDataBase;
import com.kciray.entity.menu.Pfcc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class PfccDao extends AbstractDao<Pfcc>{
    @Autowired
    public PfccDao(PfccDataBase db) {
        super(db);
    }
}
