package com.kciray.service.impl;

import com.kciray.dto.UserDto;
import com.kciray.dto.entityfilter.UserFilter;
import com.kciray.exception.ResourceNotFoundException;
import com.kciray.model.User;
import com.kciray.repository.UserRepository;
import com.kciray.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserDto save(User user) {
        User categoryCardFromSave = userRepository.save(user);
        User userGraph = userRepository.findById(categoryCardFromSave.getId()).get();
        return modelMapper.map(userGraph, UserDto.class);
    }

    public UserDto create(UserDto entityDto) {
        User categoryCardToSave = modelMapper.map(entityDto, User.class);
        if (userRepository.existsByUsername(categoryCardToSave.getUsername())) {
            throw new RuntimeException("A user with the same name already exists");
        }

        if (userRepository.existsByEmail(categoryCardToSave.getEmail())) {
            throw new RuntimeException("A user with this email already exists");
        }
        return save(categoryCardToSave);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.getByUsername(username);
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    @PostAuthorize("@securityExpression.checkGetUserPermissions(principal, returnObject)")
    public UserDto findById(Integer id) {
        return modelMapper.map(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Request with id = %id  not found", id))), UserDto.class);
    }

    public List<UserDto> findAll() {
        List<User> categories = userRepository.findAll();
        return categories.stream().map(entity -> modelMapper.map(entity, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public Page<UserDto> findAllBy(Pageable pageable) {
        Page<User> categories = userRepository.findAllBy(pageable);
        return categories.map(entity -> modelMapper.map(entity, UserDto.class));
    }

    @Override
    public List<UserDto> findAllByFilter(UserFilter userFilter) {
        return userRepository.findAllByFilter(userFilter).stream()
                .map(entity -> modelMapper.map(entity, UserDto.class)).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        userRepository.findById(id);
        userRepository.deleteById(id);
    }

    public UserDto update(Integer id, UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return modelMapper.map(userRepository.updateUser(id, user), UserDto.class);
    }

}


