package com.kciray.repository.impl;

import com.kciray.model.menu.Dish;
import com.kciray.repository.DishRepository;
import com.kciray.repository.impl.config.ConfigurationTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
class DishRepositoryImplTest extends ConfigurationTest {

    private final DishRepository dishRepository;

    @Test
    void findAllDishByRestaurantIdAndCategoryById() {
        try {
            List<Dish> allDishByRestaurantIdAndCategoryById = dishRepository.findAllDishByRestaurantIdAndCategoryById(1, 1);
            assertThat(allDishByRestaurantIdAndCategoryById).hasSize(2);
            Dish dish = allDishByRestaurantIdAndCategoryById.stream().findAny().get();
            dish.getCategory().getName();
            assertThat(true).isTrue();
        } catch (Exception e) {
            assertThat(true).isFalse();
        }

    }
}