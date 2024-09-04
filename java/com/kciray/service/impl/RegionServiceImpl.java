package com.kciray.service.impl;

import com.kciray.dao.impl.RegionDaoImpl;
import com.kciray.dto.RegionDto;
import com.kciray.entity.address.Region;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends AbstractService<Integer,Region, RegionDto>
implements BaseService<Integer,RegionDto>, RegionService{
    @Autowired
    public RegionServiceImpl(RegionDaoImpl regionDao){

        super(Region.class,RegionDto.class,regionDao);
    }
}
