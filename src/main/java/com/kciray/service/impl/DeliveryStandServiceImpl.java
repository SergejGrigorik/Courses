package com.kciray.service.impl;

import com.kciray.model.Courier;
import com.kciray.model.DeliveryStand;
import com.kciray.model.status.StatusLookCourier;
import com.kciray.repository.DeliveryStandRepository;
import com.kciray.service.DeliveryStandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeliveryStandServiceImpl implements DeliveryStandService {

    private final DeliveryStandRepository deliveryStandRepository;
    @Override
    public DeliveryStand saveAndFlush(DeliveryStand deliveryStand) {

        return deliveryStandRepository.saveAndFlush(deliveryStand);
    }

    @Override
    public Optional<DeliveryStand> findById(Integer id) {
        return deliveryStandRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        deliveryStandRepository.deleteById(id);
    }

    @Override
    public void update(Integer id, Courier freeCourier, StatusLookCourier statusLookCourier) {
        deliveryStandRepository.update(id,freeCourier,statusLookCourier);
    }

    @Override
    public void updateStatus(Integer id, StatusLookCourier statusLookCourier) {
        deliveryStandRepository.updateStatus(id,statusLookCourier);
    }
}
