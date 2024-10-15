package com.kciray.controller;

import com.kciray.dto.CouponDto;
import com.kciray.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {

    private final CouponService couponService;

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CouponDto create(@RequestBody CouponDto couponDto) {
        return couponService.create(couponDto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (couponService.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
