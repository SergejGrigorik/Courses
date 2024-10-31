package com.kciray.repository;

import com.kciray.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>, FilterUserRepository, UpdateUserRepository {

    @EntityGraph(attributePaths = {"role", "profile", "role.privileges"})
    Optional<User> findById(Integer id);

    Page<User> findAllBy(Pageable pageable);

    @EntityGraph(attributePaths = {"role", "role.privileges"})
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


}
