package com.kciray.service.basket;

import com.kciray.dto.AddressDto;
import com.kciray.dto.BasketItemDto;
import com.kciray.model.address.Address;
import com.kciray.model.order.BasketItem;
import com.kciray.repository.AddressRepository;
import com.kciray.repository.BasketItemRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.BasketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BasketItemServiceImpl extends AbstractService<Integer, BasketItem , BasketItemDto> implements BaseService<Integer, BasketItemDto>, BasketItemService {

    private final BasketItemRepository basketItemRepository;
    @Autowired
    public BasketItemServiceImpl (BasketItemRepository basketItemRepository) {
        super(BasketItem.class, BasketItemDto.class, basketItemRepository);
        this.basketItemRepository = basketItemRepository;

    }


    @Override
    public boolean deleteAll(Integer id) {
        return basketItemRepository.deleteAll();
    }
}
