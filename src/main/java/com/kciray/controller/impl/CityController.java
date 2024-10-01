package com.kciray.controller.impl;


import com.kciray.dto.CityDto;
import com.kciray.repository.CityRepository;
import com.kciray.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/city")
public class CityController  {

    private final CityService cityService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<CityDto> findAll(){
        return cityService.findAll();
    }

    @GetMapping(("/{id}"))
    public CityDto findById(@PathVariable("id") Integer id){
        return cityService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CityDto create(@RequestBody CityDto cityDto){
        return cityService.create(cityDto);
    }

    @PutMapping("/{id}")
    public CityDto update(@PathVariable("id") Integer id, @RequestBody CityDto cityDto){
        return cityService.update(id,cityDto)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        if(cityService.deleteById(id)){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }


}
