package com.kciray.controller;

import com.kciray.dto.menu.RegionDto;
import com.kciray.service.RegionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/region")
public class RegionController  {

    private final RegionService regionService;

    @GetMapping("/{id}")
    public RegionDto findById(@PathVariable("id") Integer id) {
        return regionService.findById(id);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping
    public RegionDto create(@RequestBody @Valid RegionDto regionDto) {
        return regionService.create(regionDto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PutMapping("/{id}")
    public RegionDto update(@PathVariable("id") Integer id, @RequestBody @Valid RegionDto regionDto) {
        return regionService.update(id,regionDto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        regionService.deleteById(id);
    }
}
