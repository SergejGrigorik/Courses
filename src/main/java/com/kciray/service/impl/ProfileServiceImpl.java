package com.kciray.service.impl;

import com.kciray.dto.ProfileDto;
import com.kciray.dto.address.CityDto;
import com.kciray.model.Profile;
import com.kciray.model.address.City;
import com.kciray.repository.ApplicationRepository;
import com.kciray.repository.ProfileRepository;
import com.kciray.service.AbstractService;
import com.kciray.service.ProfileService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl extends AbstractService<Integer, Profile, ProfileDto> implements ProfileService {

    protected ProfileServiceImpl(ProfileRepository profileRepository) {
        super(Profile.class, ProfileDto.class, profileRepository);
    }
}
