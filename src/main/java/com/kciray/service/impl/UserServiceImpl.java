package com.kciray.service.impl;


import com.kciray.dto.UserDto;
import com.kciray.dto.entityfilter.UserFilter;
import com.kciray.model.Role;
import com.kciray.model.User;
import com.kciray.model.status.RoleEnum;
import com.kciray.repository.UserRepository;
import com.kciray.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;


    public UserDto save(User user) {
        User categoryCardFromSave = userRepository.save(user);
        return modelMapper.map(categoryCardFromSave, UserDto.class);
    }

    public UserDto create(UserDto entityDto) {
        User categoryCardToSave = modelMapper.map(entityDto, User.class);
        if (userRepository.existsByUsername(categoryCardToSave.getUsername())) {
            // Заменить на свои исключения
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
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }


    /**
     * Выдача прав администратора текущему пользователю
     * <p>
     * Нужен для демонстрации
     */
    @Deprecated
    public void getAdmin() {
        User user = getCurrentUser();
        user.setRole(RoleEnum.ADMINISTRATOR);
        save(user);
    }


    public Optional<UserDto> findById(Integer id) {
        Optional<User> category = userRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(category.orElseThrow(() -> new RuntimeException(String.format("Entity by id = %d does not exist", id))), UserDto.class));
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

    public boolean deleteById(Integer id) {
        return userRepository.findById(id)

                .map(entity -> {
                    userRepository.deleteById(id);
                    return true;
                })
                .orElse(false);
    }

    public Optional<UserDto> update(Integer id, UserDto categoryDto) {

        userRepository.save(modelMapper.map(categoryDto, User.class));
        return findById(id);
    }


}


