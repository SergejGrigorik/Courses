package com.kciray.service;

import com.kciray.dto.UserDto;
import com.kciray.dto.entityfilter.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends BaseService<Integer, UserDto> {
    Page<UserDto> findAllBy(Pageable pageable);

    List<UserDto> findAllByFilter(UserFilter userFilter);

    UserDetailsService userDetailsService();

//    void getAdmin();
}
