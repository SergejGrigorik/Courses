package com.kciray.repository;

import com.kciray.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>, FilterUserRepository {


    @EntityGraph(attributePaths = {"role", "profile"})
    Optional<User> findById(Integer integer);

    Page<User> findAllBy(Pageable pageable);


    @EntityGraph(attributePaths = {"role"})
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
