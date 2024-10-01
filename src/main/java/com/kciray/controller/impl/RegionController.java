package com.kciray.controller.impl;

import com.kciray.dto.RegionDto;
import com.kciray.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/region")
public class RegionController  {

    private final RegionService regionService;

    @GetMapping("/{id}")
    public RegionDto findById(@PathVariable("id") Integer id) {
        return regionService.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public RegionDto create(@RequestBody RegionDto regionDto) {
        return regionService.create(regionDto);
    }

    @PutMapping("/{id}")
    public RegionDto update(@PathVariable("id") Integer id, @RequestBody RegionDto regionDto) {
        return regionService.update(id,regionDto)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        if(regionService.deleteById(id))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
