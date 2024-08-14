package com.kciray.service;

import com.kciray.dao.CourierDao;
import com.kciray.dto.CourierDto;
import com.kciray.entity.Courier;
import com.kciray.mapper.CreateEntityMapper;
import com.kciray.mapper.ReadEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourierService implements Services<Integer,CourierDto> {
    @Autowired
    private CourierDao courierDao;
    @Autowired
    private ReadEntityMapper<Courier, CourierDto> readMapper;

    @Autowired
    private CreateEntityMapper<CourierDto, Courier> createdMapper;

    public CourierDto create(CourierDto courierDto) {
        Courier courierToSave = createdMapper.toEntity(courierDto, Courier.class);
        Courier courierFromSave = courierDao.save(courierToSave);
        return readMapper.toDto(courierFromSave,CourierDto.class);
    }


    public Optional<CourierDto> findById(Integer id) {
        Optional<Courier> courier = courierDao.findById(id);
        return Optional.ofNullable(readMapper.toDto(courier.orElseThrow(()->new RuntimeException(String.format("++Entity by id = %d does not exist", id))), CourierDto.class));
    }

    public List<CourierDto> findAll() {
        List<Courier> couriers = courierDao.findAll();
        return couriers.stream().map(entity -> readMapper.toDto(entity, CourierDto.class)).collect(Collectors.toList());
    }

    public boolean deleteById(Integer id) {
        return courierDao.findById(id)
                .map(entity -> {
                    courierDao.delete(id);
                    return true;
                })
                .orElse(false);
    }

    public Optional<CourierDto> update(Integer id, CourierDto courierDto) {
        courierDao.update(id,createdMapper.toEntity(courierDto, Courier.class));
        return findById(id);

    }

}
