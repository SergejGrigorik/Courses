package com.kciray.service.basket.impl;

import com.kciray.model.order.BasketItem;
import com.kciray.repository.basket.BasketItemRepository;
import com.kciray.service.basket.BasketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BasketItemServiceImpl implements BasketItemService {

    private final BasketItemRepository basketItemRepository;

    @Override
    public void deleteAll() {
        basketItemRepository.deleteAll();
    }

    @Override
    public BasketItem save(BasketItem build) {
        return basketItemRepository.save(build);
    }

}
