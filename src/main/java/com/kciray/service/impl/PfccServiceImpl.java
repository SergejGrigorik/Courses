package com.kciray.service.impl;

import com.kciray.dto.menu.PfccDto;
import com.kciray.model.menu.Pfcc;
import com.kciray.repository.PfccRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.PfccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PfccServiceImpl extends AbstractService<Integer, Pfcc, PfccDto> implements PfccService {
    @Autowired
    public PfccServiceImpl(PfccRepository pfccRepository) {
        super(Pfcc.class, PfccDto.class, pfccRepository);
    }

}
