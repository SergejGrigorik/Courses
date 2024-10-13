package com.kciray.repository;

import com.kciray.model.menu.Category;

import java.util.Optional;

public interface CategoryRepository extends ApplicationRepository<Integer, Category> {

    Optional<Category> findCategoryWithDishById(Integer id);

}
