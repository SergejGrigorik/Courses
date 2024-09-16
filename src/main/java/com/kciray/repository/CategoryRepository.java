package com.kciray.repository;

import com.kciray.model.address.Address;
import com.kciray.model.menu.Category;

import java.util.Optional;

public interface CategoryRepository extends Repository<Integer, Category>  {
    Optional<Category> findCategoryWithDishById(Integer id);
}
