package com.kciray.repository;

import com.kciray.dto.entityfilter.UserFilter;
import com.kciray.model.User;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter user);
}
