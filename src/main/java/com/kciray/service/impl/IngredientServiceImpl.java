package com.kciray.service.impl;

import com.kciray.repository.IngredientRepository;
import com.kciray.repository.impl.IngredientRepositoryImpl;
import com.kciray.dto.IngredientDto;
import com.kciray.model.menu.Ingredient;
import com.kciray.service.AbstractService;
import com.kciray.service.BaseService;
import com.kciray.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl extends AbstractService<Integer,Ingredient,IngredientDto> implements BaseService<Integer,IngredientDto>, IngredientService {

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        super(Ingredient.class, IngredientDto.class, ingredientRepository);
    }

}
