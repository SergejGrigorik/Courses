package com.kciray.service.impl;

import com.kciray.dto.address.AddressDto;
import com.kciray.exception.ResourceNotFoundException;
import com.kciray.model.address.Address;
import com.kciray.repository.AddressRepository;
import com.kciray.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public AddressDto create(AddressDto addressDto) {
        Address mapAddress = modelMapper.map(addressDto, Address.class);
        mapAddress.getCity();
        return modelMapper.map(addressRepository.save(mapAddress), AddressDto.class);
    }

    @Override
    public boolean deleteById(Integer id) {
        return addressRepository.findById(id)
                .map(address -> {
                    addressRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAll()
                .stream().map(address -> modelMapper.map(address, AddressDto.class)).collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(Integer id) {
        return modelMapper.map(addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address with id " + id + " not found")), AddressDto.class);
    }

    @Override
    public Optional<AddressDto> update(Integer id, AddressDto addressDto) {
        Address mapAddress = modelMapper.map(addressDto, Address.class);
        mapAddress.getId();
        mapAddress.getCity();
        mapAddress.getStreet();
        mapAddress.getHouse();
        mapAddress.getApartment();
        return addressRepository.update(mapAddress.getId(),
                mapAddress.getCity(),
                mapAddress.getStreet(),
                mapAddress.getHouse(),
                mapAddress.getApartment());
    }

}
