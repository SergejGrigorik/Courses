package com.kciray.controller;

import com.kciray.dto.CourierDto;
import com.kciray.model.status.CourierStatus;
import com.kciray.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/courier")
public class CourierController {

    private final CourierService courierService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<CourierDto> findAll() {
        return courierService.findAll();
    }

    @PreAuthorize("hasRole('COURIER')")
    @GetMapping(("/{id}"))
    public CourierDto findById(@PathVariable("id") Integer id) {
        return courierService.findById(id);
    }

    @PreAuthorize("hasRole('COURIER')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CourierDto create(@RequestBody CourierDto courierDto) {
        return courierService.create(courierDto);
    }

    @PreAuthorize("hasRole({'COURIER'})")
    @PutMapping("/{id}")
    public CourierDto update(@PathVariable("id") Integer id, @RequestBody CourierDto courierDto) {
        return courierService.update(id, courierDto);
    }

    @PreAuthorize("hasRole({'COURIER'})")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        courierService.deleteById(id);
    }

    @PreAuthorize("hasRole({'COURIER'})")
    @GetMapping
    public List<CourierDto> findByCourierStatus(CourierStatus courierStatus) {
        return courierService.findAllByCourierStatus(courierStatus);
    }

}
