package com.kciray.service.impl;

import com.kciray.dao.impl.IngredientDaoImpl;
import com.kciray.dto.IngredientDto;
import com.kciray.entity.menu.Ingredient;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl extends AbstractService<Ingredient,IngredientDto> implements BaseService<Integer,IngredientDto>, IngredientService {

    @Autowired
    public IngredientServiceImpl(IngredientDaoImpl ingredientDao) {
        super(Ingredient.class, IngredientDto.class, ingredientDao);
    }

}
