package com.kciray.controller.impl;

import com.kciray.dto.PaymentCardDto;
import com.kciray.service.PaymentCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class PaymentCardController  {

    private final PaymentCardService paymentCardService;

    @GetMapping("/{id}")
    public PaymentCardDto findById(@PathVariable("id") Integer id) {
        return paymentCardService.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public PaymentCardDto create(@RequestBody PaymentCardDto paymentCardDto) {
        return paymentCardService.create(paymentCardDto);
    }

    @PutMapping("/{id}")
    public PaymentCardDto update(@PathVariable("id") Integer id, @RequestBody PaymentCardDto paymentCardDto) {
        return paymentCardService.update(id,paymentCardDto)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        if(paymentCardService.deleteById(id))
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
