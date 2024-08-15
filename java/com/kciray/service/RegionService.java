package com.kciray.service;

import com.kciray.dao.RegionDao;
import com.kciray.dto.RegionDto;
import com.kciray.entity.address.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService extends AbstractService<Region, RegionDto> implements BaseService<Integer,RegionDto> {
    @Autowired
    public RegionService(RegionDao regionDao){
        super(Region.class,RegionDto.class,regionDao);
    }
}
