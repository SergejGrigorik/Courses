package com.kciray.controller.impl;

import com.kciray.dto.CourierDto;
import com.kciray.model.status.CourierStatus;
import com.kciray.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/courier")
public class CourierController  {

    private final CourierService courierService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<CourierDto> findAll(){
        return courierService.findAll();
    }

    @GetMapping(("/{id}"))
    public CourierDto findById(@PathVariable("id") Integer id){
        return courierService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CourierDto create(@RequestBody CourierDto courierDto ){
        return courierService.create(courierDto);
    }

    @PutMapping("/{id}")
    public CourierDto update(@PathVariable("id") Integer id, @RequestBody CourierDto courierDto){
        return courierService.update(id,courierDto)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        if(courierService.deleteById(id)){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public List<CourierDto> findByCourierStatus(CourierStatus courierStatus){
        return courierService.findAllByCourierStatus(courierStatus);
    }

}
