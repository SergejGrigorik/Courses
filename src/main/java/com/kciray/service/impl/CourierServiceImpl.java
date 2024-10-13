package com.kciray.service.impl;

import com.kciray.dto.CourierDto;
import com.kciray.exception.ResourceNotFoundException;
import com.kciray.model.Courier;
import com.kciray.model.DeliveryStand;
import com.kciray.model.ScheduleCourierForDay;
import com.kciray.model.status.CourierStatus;
import com.kciray.model.status.StatusBusyCourier;
import com.kciray.repository.CourierRepository;
import com.kciray.service.CourierService;
import com.kciray.service.ScheduleCourierForDayService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CourierServiceImpl implements CourierService {

    private final ModelMapper modelMapper;
    private final CourierRepository courierRepository;
    private final ScheduleCourierForDayService scheduleCourierForDayService;
    private DeliveryStand deliveryStand;
    private LocalDate date;


    @Override
    public List<CourierDto> findAllByCourierStatus(CourierStatus courierStatus) {
        return null;
    }

    private Optional<Courier> findAllByCourierFreeTime() {

        List<ScheduleCourierForDay> scheduleCourierForDays = scheduleCourierForDayService.findByTimeFromAndTimeToAndDayAndStatusHas
                (deliveryStand.getDeliveryTime(), findDayOfWeekFromDate(), StatusBusyCourier.FREE.name());
        if (scheduleCourierForDays.isEmpty()) {
            return Optional.empty();
        }
        ScheduleCourierForDay scheduleCourierForDay = scheduleCourierForDays.get(0);
        scheduleCourierForDayService.updateStatus(scheduleCourierForDay.getId(), StatusBusyCourier.BUSY);
        return Optional.ofNullable(scheduleCourierForDay.getCourier());

    }

    @SneakyThrows
    public Optional<Courier> getFreeCourier(DeliveryStand deliveryStand) {
        this.date = deliveryStand.getDeliveryDate();
        this.deliveryStand = deliveryStand;
        return findAllByCourierFreeTime();
    }

    private String findDayOfWeekFromDate() {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String day = String.valueOf(dayOfWeek);
        return day;
    }


    @Override
    public CourierDto create(CourierDto courierDto) {
        Courier courier = modelMapper.map(courierDto, Courier.class);
        courierRepository.saveAndFlush(courier);
        return modelMapper.map(courierRepository.saveAndFlush(courier), CourierDto.class);
    }

    @Override
    public CourierDto findById(Integer id) {
        return modelMapper.map(courierRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Request with id = %id  not found", id))), CourierDto.class);
    }

    @Override
    public List<CourierDto> findAll() {
        return courierRepository.findAll().stream()
                .map(courier -> modelMapper.map(courier, CourierDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        courierRepository.findById(id);
        courierRepository.deleteById(id);
    }

    @Override
    public CourierDto update(Integer id, CourierDto courierDto) {
        Courier courier = modelMapper.map(courierDto, Courier.class);
        Courier updateCourier = courierRepository.update(courier.getId(),
                courier.getUser(),
                courier.getCourierStatus());
        return modelMapper.map(updateCourier,CourierDto.class);
    }
}

