package com.kciray.service.impl;

import com.kciray.dao.impl.PfccDaoImpl;
import com.kciray.dto.PfccDto;
import com.kciray.entity.menu.Pfcc;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.PfccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PfccServiceImpl extends AbstractService<Pfcc, PfccDto> implements BaseService<Integer, PfccDto>, PfccService {
    @Autowired
    public PfccServiceImpl(PfccDaoImpl pfccDao) {
        super(Pfcc.class, PfccDto.class, pfccDao);
    }
}
