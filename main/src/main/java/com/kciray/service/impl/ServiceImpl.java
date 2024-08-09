package com.kciray.service.impl;

import com.kciray.dao.DaoInterface;
import com.kciray.service.ServiceInterface;
import org.springframework.annotation.autowired.annotation.Autowired;
import org.springframework.annotation.component.Component;

@Component
public class ServiceImpl implements ServiceInterface {
    private DaoInterface daoInterface;

    @Autowired
    private void setDaoInterface(DaoInterface daoInterface) {
        this.daoInterface = daoInterface;
    }

    @Override
    public void execute() {
        daoInterface.execute();
    }

}
