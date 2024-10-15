package com.kciray.repository;

import com.kciray.model.User;

public interface UpdateUserRepository {
     User updateUser(Integer id, User user);
}
