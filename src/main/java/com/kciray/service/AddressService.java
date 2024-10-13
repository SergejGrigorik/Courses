package com.kciray.service;

import com.kciray.dto.address.AddressDto;
import java.util.List;
import java.util.Optional;

public interface AddressService {
    AddressDto create(AddressDto address);

    List<AddressDto> findAll();

    AddressDto findById(Integer id);

    Optional<AddressDto> update(Integer id, AddressDto addressDto);

    boolean deleteById(Integer id);
}
