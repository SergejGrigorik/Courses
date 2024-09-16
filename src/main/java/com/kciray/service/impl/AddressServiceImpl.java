package com.kciray.service.impl;

import com.kciray.dto.AddressDto;

import com.kciray.model.address.Address;

import com.kciray.repository.AddressRepository;
import com.kciray.repository.impl.AddressRepositoryImpl;
import com.kciray.service.AbstractService;
import com.kciray.service.AddressService;
import com.kciray.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends AbstractService<Integer, Address, AddressDto> implements BaseService<Integer, AddressDto>, AddressService {

    @Autowired
    public AddressServiceImpl (AddressRepository addressRepository) {
        super(Address.class, AddressDto.class, addressRepository);

    }


}
