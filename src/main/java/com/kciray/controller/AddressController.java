package com.kciray.controller;

import com.kciray.dto.address.AddressDto;
import com.kciray.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    //        @Secured("change schedule_courier")
    @PreAuthorize("hasRole('')")
//    @PreAuthorize("hasRole('change schedule_courier1')")
    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable("id") Integer id) {
        return addressService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public AddressDto create(@RequestBody AddressDto addressDto) {
        return addressService.create(addressDto);
    }

    @PutMapping("/{id}")
    public AddressDto update(@PathVariable("id") Integer id, @RequestBody AddressDto addressDto) {
        return addressService.update(id, addressDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (addressService.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
