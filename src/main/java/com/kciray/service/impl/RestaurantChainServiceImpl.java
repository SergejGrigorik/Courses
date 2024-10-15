package com.kciray.service.impl;

import com.kciray.dto.RestaurantChainDto;
import com.kciray.model.RestaurantChain;
import com.kciray.repository.ApplicationRepository;
import com.kciray.repository.RestaurantChainRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.RestaurantChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantChainServiceImpl extends AbstractService<Integer, RestaurantChain, RestaurantChainDto> implements RestaurantChainService {

    @Autowired
    protected RestaurantChainServiceImpl(RestaurantChainRepository repository) {
        super(RestaurantChain.class, RestaurantChainDto.class, repository);
    }
}
