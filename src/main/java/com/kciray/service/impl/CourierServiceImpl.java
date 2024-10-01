package com.kciray.service.impl;


import com.kciray.dto.CourierDto;
import com.kciray.model.Courier;
import com.kciray.model.status.CourierStatus;
import com.kciray.repository.CourierRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@Transaction

public class CourierServiceImpl extends AbstractService<Integer, Courier, CourierDto> implements BaseService<Integer, CourierDto>, CourierService {
    @Autowired
    private CourierRepository courierRepository;

    @Autowired
    public CourierServiceImpl(CourierRepository courierRepository) {
        super(Courier.class, CourierDto.class, courierRepository);
    }


    @Override
    public List<CourierDto> findAllByCourierStatus(CourierStatus courierStatus) {
        List<Courier> allByCourierStatus = courierRepository.findAllByCourierStatus(courierStatus);
        return allByCourierStatus.stream()
                .map(courier -> modelMapper.map(courier,CourierDto.class)).collect(Collectors.toList());
    }
}

