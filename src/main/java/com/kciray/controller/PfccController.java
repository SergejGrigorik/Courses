package com.kciray.controller;

import com.kciray.dto.menu.PfccDto;
import com.kciray.service.PfccService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasRole('OPERATOR')")
    @GetMapping("/{id}")
    public PfccDto findById(@PathVariable("id") Integer id) {
        return pfccService.findById(id);
    }

    @PreAuthorize("hasRole('OPERATOR')")
    @PostMapping
    public PfccDto create(@RequestBody PfccDto pfccDto) {
        return pfccService.create(pfccDto);
    }

    @PreAuthorize("hasRole('OPERATOR')")
    @PutMapping("/{id}")
    public PfccDto update(@PathVariable("id") Integer id, @RequestBody PfccDto pfccDto) {
        return pfccService.update(id, pfccDto);
    }

    @PreAuthorize("hasRole('DELETE_DISH')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        pfccService.deleteById(id);
    }
}
