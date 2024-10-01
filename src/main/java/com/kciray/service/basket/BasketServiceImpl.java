package com.kciray.service.basket;

import com.kciray.dto.BasketDto;
import com.kciray.dto.DishDto;
import com.kciray.model.User;
import com.kciray.model.menu.Dish;
import com.kciray.model.order.Basket;
import com.kciray.model.order.BasketItem;
import com.kciray.model.status.StatusFullness;
import com.kciray.repository.BasketRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BasketServiceImpl extends AbstractService<Integer, Basket, BasketDto> implements BaseService<Integer, BasketDto>, BasketService {

    private  BasketRepository basketRepository;
    @Autowired
    private  ModelMapper modelMapper;
    private Dish dish;
    private Basket basketIsEmpty;
    private Basket basketIsNonEmpty;
    private BasketItem basketItem;

    @Autowired
    public BasketServiceImpl (BasketRepository basketRepository) {
        super(Basket.class, BasketDto.class, basketRepository);
        this.basketRepository = basketRepository;
    }

    public Dish addDish(DishDto dto) {
        Optional<Basket> basket = basketRepository.findByUserId(getUser().getId());
        dish = modelMapper.map(dto, Dish.class);
        if (basket.isEmpty()) {
            basketIsEmpty = createBasket();
            basketItem = createBasketItem(basketIsEmpty);
        } else if (basket.get().getRestaurant().getId().equals(dish.getRestaurant().getId())) {
            basketIsNonEmpty = basket.get();
            basketItem = createBasketItem(basketIsNonEmpty);
        } else {
            throw new RuntimeException("Cannot difrens restaurant !!!!!!!!!!!!!!!!!");
        }
        return null;
    }


    public Basket createBasket() {
        return basketRepository.saveBasket(Basket
                .builder()
                .restaurant(dish.getRestaurant())
                .user(getUser())
                .statusFullness(StatusFullness.NONEMPTY)
                .build());
    }

    public BasketItem createBasketItem(Basket basket) {
        return basketRepository.saveBasketItem(BasketItem.builder()
                .basket(basket)
                .dish(dish)
                .price(dish.getPrice())
                .build());
    }


    public User getUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(ctx -> ctx.getAuthentication())
                .map(auth -> auth.getPrincipal())
                .filter(p -> p instanceof User)
                .map(u -> ((User) u)).get();
    }

}
