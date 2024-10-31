package com.kciray.controller;

import com.kciray.dto.CouponDto;
import com.kciray.service.CouponService;
import jakarta.validation.Valid;
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

    @PreAuthorize("hasRole('OPERATOR')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CouponDto create(@RequestBody @Valid CouponDto couponDto) {
        return couponService.create(couponDto);
    }

    @PreAuthorize("hasRole('DELETE_COUPON')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (couponService.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
