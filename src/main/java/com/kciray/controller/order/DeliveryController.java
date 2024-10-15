package com.kciray.controller.order;

import com.kciray.dto.address.AddressDto;
import com.kciray.service.order.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PreAuthorize("hasRole('ADMINISTRATOR')")
    @PostMapping("/create")
    public void createDelivery(String promoCod,
                               @RequestParam("time") @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm") LocalDateTime time,
                               @RequestBody AddressDto addressDto) {
        deliveryService.createDelivery(time.toLocalDate(), time.toLocalTime(), promoCod, addressDto);
    }
}
