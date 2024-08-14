package com.kciray.service;

import com.kciray.dao.IngredientDao;
import com.kciray.dto.IngredientDto;
import com.kciray.entity.menu.Ingredient;
import com.kciray.mapper.CreateEntityMapper;
import com.kciray.mapper.ReadEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientService implements Services<Integer,IngredientDto> {
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private ReadEntityMapper<Ingredient, IngredientDto> readMapper;

    @Autowired
    private CreateEntityMapper<IngredientDto, Ingredient> createdMapper;

    public IngredientDto create(IngredientDto ingredientDto ) {
        Ingredient ingredient = createdMapper.toEntity(ingredientDto,Ingredient.class );
        Ingredient ingredientAfterSave = ingredientDao.save(ingredient);

        return readMapper.toDto(ingredientAfterSave,IngredientDto.class);
    }


    public Optional<IngredientDto> findById(Integer id) {
        Optional<Ingredient> ingredient = ingredientDao.findById(id);
        return Optional.ofNullable(readMapper.toDto(ingredient.orElseThrow(()->new RuntimeException(String.format("++Entity by id = %d does not exist", id))), IngredientDto.class));
    }

    public List<IngredientDto> findAll() {
        List<Ingredient> categories = ingredientDao.findAll();
        return categories.stream().map(entity -> readMapper.toDto(entity, IngredientDto.class)).collect(Collectors.toList());
    }

    public boolean deleteById(Integer id) {
        return ingredientDao.findById(id)
                .map(entity -> {
                    ingredientDao.delete(id);
                    return true;
                })
                .orElse(false);
    }

    public Optional<IngredientDto> update(Integer id, IngredientDto ingredientDto) {
        ingredientDao.update(id,createdMapper.toEntity(ingredientDto, Ingredient.class));
        return findById(id);

    }
}
