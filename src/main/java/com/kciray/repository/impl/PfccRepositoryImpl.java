package com.kciray.repository.impl;

import com.kciray.model.menu.Pfcc;
import com.kciray.repository.ApplicationRepository;
import com.kciray.repository.PfccRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PfccRepositoryImpl implements PfccRepository, ApplicationRepository<Integer, Pfcc> {

    private static final String SAVE = """
            INSERT INTO pfcc(proteins,
            fats,
            calories,
            carbohydrates)
            VALUES(?,?,?,?)
            """;
    private static final String FIND_BY_ID = """
            SELECT * FROM pfcc
            WHERE id = ?
            """;
    private static final String UPDATE = """
            UPDATE pfcc SET proteins = ?,
            fats = ?,
            calories = ?,
            carbohydrates = ?
            WHERE id = ?
            """;
    private static final String DELETE = """
            DELETE FROM pfcc 
            WHERE id = ?
            """;
    private static final String FIND_ALL = """
            SELECT * FROM pfcc
            """;

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Pfcc save(Pfcc entity) {
        jdbcTemplate.update(SAVE, entity.getFats(), entity.getCalories(), entity.getCalories(),
                entity.getCarbohydrates());
        return entity;
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(DELETE, id);
    }

    @Override
    public void update(Pfcc entity) {
        jdbcTemplate.update(UPDATE, entity.getFats(), entity.getCalories(), entity.getCalories(),
                entity.getCarbohydrates(), entity.getId());
    }

    @Override
    public Optional<Pfcc> findById(Integer id) {
        return jdbcTemplate.query(FIND_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(Pfcc.class))
                .stream().findAny();
    }


    @Override
    public List<Pfcc> findAll() {
        return new ArrayList<>(jdbcTemplate.query(FIND_ALL, new Object[]{}, new BeanPropertyRowMapper<>(Pfcc.class)));
    }
}
