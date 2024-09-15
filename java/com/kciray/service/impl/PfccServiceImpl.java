package com.kciray.service.impl;



import com.kciray.repository.impl.PfccRepositoryImpl;
import com.kciray.dto.PfccDto;
import com.kciray.model.menu.Pfcc;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.PfccService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service


public class PfccServiceImpl extends AbstractService<Integer,Pfcc, PfccDto> implements BaseService<Integer,PfccDto>,
PfccService{


    @Autowired
    public PfccServiceImpl(PfccRepositoryImpl pfccDao) {
        super(Pfcc.class, PfccDto.class, pfccDao);
    }


}
