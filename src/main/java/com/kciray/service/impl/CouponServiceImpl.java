package com.kciray.service.impl;

import com.kciray.dto.CouponDto;
import com.kciray.model.Coupon;
import com.kciray.model.status.Validity;
import com.kciray.repository.CouponRepository;
import com.kciray.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public Coupon findByPromoCodeAndRestaurantId(String promoCode, Integer restaurantId) {
        return repository.findByPromoCodeAndRestaurantId(promoCode, restaurantId);
    }

    @Override
    public CouponDto create(CouponDto couponDto) {
        Coupon coupon = modelMapper.map(couponDto, Coupon.class);
        return modelMapper.map(repository.save(coupon), CouponDto.class);
    }

    @Override
    public boolean deleteById(Integer id) {
        return repository.findById(id)
                .map(coupon -> {
                    repository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public void updateValidity(Validity coupon, Integer id) {
        repository.updateValidity(coupon, id);
    }
}
