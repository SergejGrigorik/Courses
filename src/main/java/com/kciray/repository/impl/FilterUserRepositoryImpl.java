package com.kciray.repository.impl;

import com.kciray.dto.entityfilter.UserFilter;
import com.kciray.model.User;
import com.kciray.repository.FilterUserRepository;
import com.kciray.service.querydsl.QPredicates;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.kciray.model.QUser.user;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

    private final EntityManager em;

    @Override
    public List<User> findAllByFilter(UserFilter filter) {
        Predicate predicate = QPredicates.builder()
                .add(filter.login(), user.email::containsIgnoreCase)
                .add(filter.firstName(), user.profile.firstName::containsIgnoreCase)
                .add(filter.lastName(), user.profile.lastName::containsIgnoreCase)
                .add(String.valueOf(filter.number()), user.profile.number.stringValue()::containsIgnoreCase)
                .build();
        return new JPAQuery<User>(em)
                .select(user)
                .from(user)
                .where(predicate)
                .fetch();
    }
}
