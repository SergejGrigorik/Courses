package com.kciray.repository.impl;

import com.kciray.model.Restaurant;
import com.kciray.repository.RestaurantRepository;
import com.kciray.repository.impl.config.ConfigurationRepositoryTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@RequiredArgsConstructor
class RestaurantRepositoryImplTest extends ConfigurationRepositoryTest {

    private final int id = 1;
    private final RestaurantRepository repository;

    @Test
    void findById() {
        Optional<Restaurant> byId = repository.findById(id);
        assertTrue(byId.isPresent());
        assertThat(byId.get().getId()).isEqualTo(id);
    }

    @Test
    void findAll() {
        Set<Integer> setId = Set.of(1, 2, 3);
        List<Restaurant> all = repository.findAll();
        assertNotNull(all);
        List<Integer> list = all.stream().map(Restaurant::getId).toList();
        assertThat(list).contains(setId.stream().iterator().next());
    }


    @Test
    void findAddressAndRestaurantById() {
        try {

            Restaurant addressAndRestaurantById = repository.findAddressAndRestaurantById(id);
            assertNotNull(addressAndRestaurantById);
            assertThat(addressAndRestaurantById.getId()).isEqualTo(id);
            addressAndRestaurantById.getAddress().getStreet();
            assertThat(true).isTrue();
        } catch (Exception e) {
            assertThat(true).isFalse();
        }
    }

}