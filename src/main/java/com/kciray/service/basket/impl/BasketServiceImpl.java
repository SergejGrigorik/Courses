package com.kciray.service.basket.impl;

import com.kciray.dto.menu.DishDto;
import com.kciray.exception.ProductOneRestaurantException;
import com.kciray.exception.MissingDishException;
import com.kciray.model.User;
import com.kciray.model.menu.Dish;
import com.kciray.model.order.Basket;
import com.kciray.model.order.BasketItem;
import com.kciray.model.status.StatusAvailability;
import com.kciray.model.status.StatusFullness;
import com.kciray.repository.basket.BasketRepository;
import com.kciray.service.basket.BasketItemService;
import com.kciray.service.basket.BasketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final ModelMapper modelMapper;
    private final BasketItemService basketItemService;
    private Dish dish;
    private Basket basketIsEmpty;
    private Basket basketIsNonEmpty;

    public Dish addDish(DishDto dto) {
        dish = modelMapper.map(dto, Dish.class);
        checkAvailability();
        Optional<Basket> basket = basketRepository.findByUserId(getUser().getId());

        if (basket.isEmpty()) {
            basketIsEmpty = createBasket();
            createBasketItem(basketIsEmpty);
        } else if (basket.get().getRestaurant().getId().equals(dish.getRestaurant().getId())) {
            basketIsNonEmpty = basket.get();
            createBasketItem(basketIsNonEmpty);
        } else {
            throw new ProductOneRestaurantException("The products in the basket must beat one restaurant");
        }
        return dish;
    }

    private void checkAvailability() {
        if(dish.getAvailability().equals(StatusAvailability.NOTAVAIBALE)){
            throw new MissingDishException("Dish not available");
        }
    }

    @Override
    public void deleteById(Integer id) {
        basketRepository.deleteById(id);
    }

    public Basket createBasket() {
        return basketRepository.save(Basket
                .builder()
                .restaurant(dish.getRestaurant())
                .user(getUser())
                .statusFullness(StatusFullness.NONEMPTY)
                .build());
    }

    public BasketItem createBasketItem(Basket basket) {
        return basketItemService.save(BasketItem.builder()
                .basket(basket)
                .dish(dish)
                .price(dish.getPrice())
                .build());
    }

    public User getUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(auth -> auth.getPrincipal())
                .filter(p -> p instanceof User)
                .map(u -> ((User) u)).get();
    }
}
