package com.kciray.service.impl;

import com.kciray.repository.impl.RegionRepositoryImpl;
import com.kciray.dto.RegionDto;
import com.kciray.model.address.Region;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends AbstractService<Integer,Region, RegionDto>
implements BaseService<Integer,RegionDto>, RegionService{
    @Autowired
    public RegionServiceImpl(RegionRepositoryImpl regionDao){

        super(Region.class,RegionDto.class,regionDao);
    }
}
