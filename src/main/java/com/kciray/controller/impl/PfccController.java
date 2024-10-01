package com.kciray.controller.impl;


import com.kciray.dto.PfccDto;

import com.kciray.service.PfccService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/pfcc")
public class PfccController {

    private final PfccService pfccService;

    @GetMapping
    public List<PfccDto> findAll() {
        return pfccService.findAll();
    }

    @GetMapping("/{id}")
    public PfccDto findById(@PathVariable("id") Integer id) {
        return pfccService.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public PfccDto create(@RequestBody PfccDto pfccDto) {
        return pfccService.create(pfccDto);
    }

    @PutMapping("/{id}")
    public PfccDto update(@PathVariable("id") Integer id, @RequestBody PfccDto pfccDto) {
        return pfccService.update(id,pfccDto)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        if(pfccService.deleteById(id))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}
