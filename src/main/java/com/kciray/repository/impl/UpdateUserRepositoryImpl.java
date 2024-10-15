package com.kciray.repository.impl;

import com.kciray.model.User;
import com.kciray.repository.UpdateUserRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateUserRepositoryImpl implements UpdateUserRepository {

    private final EntityManager em;

    @Override
    public User updateUser(Integer id, User user) {
        return em.merge(user);
    }
}
