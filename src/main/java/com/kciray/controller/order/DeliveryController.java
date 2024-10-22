package com.kciray.controller.order;

import com.kciray.dto.DeliveryDto;
import com.kciray.dto.address.AddressDto;
import com.kciray.service.order.DeliveryService;
import com.kciray.validated.Create;
import com.kciray.validated.Update;
import jakarta.validation.groups.Default;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/create")
    public void createDelivery(String promoCod,
                               @RequestParam("time") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm") LocalDateTime time,
                               @RequestBody  AddressDto addressDto) {
        deliveryService.createDelivery(time.toLocalDate(), time.toLocalTime(), promoCod, addressDto);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DeliveryDto> findAll() {
        return deliveryService.findAll();
    }

    @GetMapping("/{id}")
    public DeliveryDto findById(@PathVariable("id") Integer id) {
        return deliveryService.findById(id);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public DeliveryDto update(@PathVariable("id") Integer id, @RequestBody @Validated({Default.class , Create.class}) DeliveryDto deliveryDto) {
        return deliveryService.update(id, deliveryDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        deliveryService.deleteById(id);
    }


}
