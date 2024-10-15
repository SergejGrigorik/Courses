package com.kciray.service.order.impl;

import com.kciray.dto.address.AddressDto;
import com.kciray.model.*;
import com.kciray.model.address.Address;
import com.kciray.model.order.Order;
import com.kciray.model.status.StatusLookCourier;
import com.kciray.repository.order.DeliveryRepository;
import com.kciray.service.AddressService;
import com.kciray.service.CourierService;
import com.kciray.service.DeliveryStandService;
import com.kciray.service.ScheduleRestaurantService;
import com.kciray.service.order.DeliveryService;
import com.kciray.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.TemporalAdjusters.nextOrSame;

@Service
@RequiredArgsConstructor
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    private final OrderService orderService;
    private final ModelMapper modelMapper;
    private final CourierService courierService;
    private final DeliveryRepository deliveryRepository;
    private final DeliveryStandService deliveryStandService;
    private final ScheduleRestaurantService scheduleRestaurantService;
    private Delivery deliverySave;
    private Order order;
    private Address address;
    private LocalDate dateDelivery;
    private LocalTime timeDelivery;
    private DeliveryStand deliveryStandSave;
    private Restaurant restaurant;
    private AddressDto addressDto;

    @Override
    public void createDelivery(LocalDate date, LocalTime time, String promoCode, AddressDto addressDto) {
        this.addressDto = addressDto;
        this.dateDelivery = date;
        this.timeDelivery = time;
        order = orderService.getOrder(promoCode);
        restaurant = orderService.getBasket().getRestaurant();
        checkScheduleRestaurant();
        validityDate();
        address = modelMapper.map(addressDto, Address.class);
        Delivery delivery = Delivery.builder()
                .order(order)
                .courier(null)
                .deliveryDate(date)
                .deliveryTime(time)
                .deliveryAddress(address)
                .restaurant(restaurant)
                .lookCourier(StatusLookCourier.SEARCH)
                .build();
        deliverySave = deliveryRepository.saveAndFlush(delivery);
        DeliveryStand deliveryStand = DeliveryStand.builder()
                .courier(null)
                .deliveryDate(date)
                .deliveryTime(time)
                .deliveryAddress(address)
                .delivery(deliverySave)
                .restaurant(restaurant)
                .createdAt(LocalDateTime.now())
                .lookCourier(StatusLookCourier.SEARCH)
                .build();
        deliveryStandSave = deliveryStandService.saveAndFlush(deliveryStand);
        findByCourierForOrder();
    }

    private void checkScheduleRestaurant() {
        Optional<ScheduleRestaurant> scheduleRestaurant = Optional.ofNullable(scheduleRestaurantService.findByRestaurantId(restaurant.getId(), findDayOfWeekFromDate()));
        if (scheduleRestaurant.isPresent()) {
            throw new RuntimeException("The restaurant is closed on this day");
        }
        if (timeDelivery.isBefore(scheduleRestaurant.get().getWorkingHoursFrom()) || timeDelivery.isAfter(scheduleRestaurant.get().getWorkingHoursTo())) {
            throw new RuntimeException("The restaurant is closed at this time");
        }

    }

    private String findDayOfWeekFromDate() {
        DayOfWeek dayOfWeek = dateDelivery.getDayOfWeek();
        String day = String.valueOf(dayOfWeek);
        return day;
    }

    private void validityDate() {
        LocalDate now = LocalDate.now();
        LocalDate dateSunday = now.with(nextOrSame(DayOfWeek.SUNDAY));
        if (dateDelivery.isAfter(dateSunday)) {
            throw new RuntimeException("Orders are accepted only during this week");
        }
    }

    @Scheduled(fixedRateString = "${scheduled.fixedRateString.time.find_courier}", timeUnit = TimeUnit.MINUTES)
    @Override
    public void findByCourierForOrder() {
        if (order == null) {
            return;
        }
        DeliveryStand deliveryStand = deliveryStandService.findById(deliveryStandSave.getId()).get();
        LocalDateTime dateTimePlus3Minutes = deliveryStand.getCreatedAt().minusMinutes(3);
        if (dateTimePlus3Minutes.isAfter(LocalDateTime.now()) && deliveryStand.getCourier() != null) {
            deliverySave.setCourier(deliveryStand.getCourier());
            deliveryRepository.update(deliverySave.getId(), deliverySave.getCourier(), StatusLookCourier.FOUND);
            deliveryStandService.updateStatus(deliveryStandSave.getId(), StatusLookCourier.FOUND);
            deliveryStandService.deleteById(deliveryStand.getId());

        } else if (dateTimePlus3Minutes.isBefore(LocalDateTime.now()) && deliveryStand.getCourier() == null) {
            Optional<Courier> freeCourier = courierService.getFreeCourier(deliveryStandSave);
            if (freeCourier.isPresent()) {
                deliverySave.setCourier(freeCourier.get());
                deliveryStandService.update(deliveryStandSave.getId(), freeCourier.get(), StatusLookCourier.FOUND);
                deliveryRepository.update(deliverySave.getId(), freeCourier.get(), StatusLookCourier.FOUND);
                deliveryStandService.deleteById(deliveryStand.getId());
            } else {
                deliveryStandService.updateStatus(deliveryStandSave.getId(), StatusLookCourier.NOTFOUND);
                deliveryRepository.updateStatus(deliverySave.getId(), StatusLookCourier.NOTFOUND);
                ;
            }
        }


    }

    public User getUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(ctx -> ctx.getAuthentication())
                .map(auth -> auth.getPrincipal())
                .filter(p -> p instanceof User)
                .map(u -> ((User) u)).get();
    }
}



