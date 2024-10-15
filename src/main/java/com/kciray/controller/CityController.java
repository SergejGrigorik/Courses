package com.kciray.controller;

import com.kciray.dto.address.CityDto;
import com.kciray.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/city")
public class CityController {

    private final CityService cityService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<CityDto> findAll() {
        return cityService.findAll();
    }

    @GetMapping(("/{id}"))
    public CityDto findById(@PathVariable("id") Integer id) {
        return cityService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CityDto create(@RequestBody CityDto cityDto) {
        return cityService.create(cityDto);
    }

    @PutMapping("/{id}")
    public CityDto update(@PathVariable("id") Integer id, @RequestBody CityDto cityDto) {
        return cityService.update(id, cityDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        cityService.deleteById(id);

    }
    @GetMapping("/findByRegion")
    @ResponseStatus(HttpStatus.OK)
    public List<CityDto> findByRegion(@ParameterObject String regionName) {
       return cityService.findByRegionName(regionName);
    }
}
