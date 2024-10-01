package com.kciray.service;

import com.kciray.dto.BasketItemDto;
import com.kciray.model.order.BasketItem;

public interface BasketItemService extends BaseService<Integer, BasketItemDto>{
    boolean deleteAll(Integer id);
}
