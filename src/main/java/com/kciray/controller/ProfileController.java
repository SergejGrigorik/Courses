package com.kciray.controller;

import com.kciray.dto.ProfileDto;
import com.kciray.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private List<ProfileDto> findAll() {
        return profileService.findAll();
    }

    @GetMapping(("/{id}"))
    public ProfileDto findById(@PathVariable("id") Integer id) {
        return profileService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProfileDto create(@RequestBody ProfileDto profileDto) {
        return profileService.create(profileDto);
    }

    @PutMapping("/{id}")
    public ProfileDto update(@PathVariable("id") Integer id, @RequestBody ProfileDto profileDto) {
        return profileService.update(id, profileDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        profileService.deleteById(id);
    }
}
