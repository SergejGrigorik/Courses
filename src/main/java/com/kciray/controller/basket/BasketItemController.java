package com.kciray.controller.basket;


import com.kciray.dto.AddressDto;
import com.kciray.dto.BasketItemDto;
import com.kciray.service.AddressService;
import com.kciray.service.BasketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/basketitem")
public class BasketItemController {
    private final BasketItemService basketItemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BasketItemDto> findAll() {
        return basketItemService.findAll();
    }

    @GetMapping("/{id}")
    public BasketItemDto findById(@PathVariable("id") Integer id) {

        return basketItemService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BasketItemDto create(@RequestBody BasketItemDto addressDto) {
        return basketItemService.create(addressDto);
    }

    @PutMapping("/{id}")
    public BasketItemDto update(@PathVariable("id") Integer id, @RequestBody BasketItemDto basketItemDto) {
        return basketItemService.update(id, basketItemDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (basketItemService.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll(@PathVariable("id") Integer id) {
        if (basketItemService.deleteAll(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
