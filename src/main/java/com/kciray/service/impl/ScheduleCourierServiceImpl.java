package com.kciray.service.impl;

import com.kciray.model.ScheduleCourier;
import com.kciray.repository.ScheduleCourierRepository;
import com.kciray.service.ScheduleCourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleCourierServiceImpl implements ScheduleCourierService {
    private final ScheduleCourierRepository scheduleCourierRepository;

    @Override
    public List<ScheduleCourier> findAll() {
        return scheduleCourierRepository.findAll();
    }
}
