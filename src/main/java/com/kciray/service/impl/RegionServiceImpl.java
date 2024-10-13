package com.kciray.service.impl;

import com.kciray.repository.RegionRepository;
import com.kciray.dto.menu.RegionDto;
import com.kciray.model.address.Region;
import com.kciray.service.AbstractService;
import com.kciray.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends AbstractService<Integer,Region, RegionDto>
implements  RegionService{
    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository){

        super(Region.class,RegionDto.class,regionRepository);
    }
}
