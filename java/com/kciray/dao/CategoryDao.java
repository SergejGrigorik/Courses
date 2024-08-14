package com.kciray.dao;

import com.kciray.database.CategoryDataBase;
import com.kciray.entity.menu.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends AbstractDao<Category>  {
    @Autowired
    public CategoryDao(CategoryDataBase categoryDataBase) {
        super(categoryDataBase);
    }
}
