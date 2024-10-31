package com.kciray.repository.impl;

import com.kciray.model.address.Address;
import com.kciray.repository.AddressRepository;
import com.kciray.repository.impl.config.ConfigurationRepositoryTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
class AddressRepositoryImplTest extends ConfigurationRepositoryTest {

    private final  AddressRepository addressRepository;
    private final int id = 1;


    @Test
    void findById() {
        try {
            Optional<Address> byId = addressRepository.findById(id);
            assertTrue(byId.isPresent());
            assertEquals(id, byId.get().getId());
            byId.get().getCity().getNameCity();
            byId.get().getCity().getRegion().getNameRegion();
            assertThat(true).isTrue();
        }catch (Exception e){

            assertThat(true).isFalse();
        }
    }



}