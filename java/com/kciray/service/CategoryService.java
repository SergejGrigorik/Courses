package com.kciray.service;

import com.kciray.dao.CategoryDao;
import com.kciray.dto.CategoryDto;
import com.kciray.entity.menu.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService
        extends AbstractService<Category, CategoryDto> implements BaseService<Integer, CategoryDto> {

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        super(Category.class, CategoryDto.class, categoryDao);
    }

}











//
//implements Services<Integer,CategoryDto> {
//    @Autowired
//    private CategoryDao categoryDao;
//    @Autowired
//    private ReadEntityMapper<Category, CategoryDto> readMapper;
//
//    @Autowired
//    private CreateEntityMapper<CategoryDto, Category> createdMapper;
//
//    public CategoryDto create(CategoryDto categoryDto) {
//        Category categoryCardToSave = createdMapper.toEntity(categoryDto, Category.class);
//        Category categoryCardFromSave = categoryDao.save(categoryCardToSave);
//        return readMapper.toDto(categoryCardFromSave,CategoryDto.class);
//    }
//
//
//    public Optional<CategoryDto> findById(Integer id) {
//        Optional<Category> category = categoryDao.findById(id);
//        return Optional.ofNullable(readMapper.toDto(category.orElseThrow(()->new RuntimeException(String.format("++Entity by id = %d does not exist", id))), CategoryDto.class));
//    }
//
//    public List<CategoryDto> findAll() {
//        List<Category> categories = categoryDao.findAll();
//        return categories.stream().map(entity -> readMapper.toDto(entity, CategoryDto.class)).collect(Collectors.toList());
//    }
//
//    public boolean deleteById(Integer id) {
//        return categoryDao.findById(id)
//                .map(entity -> {
//                    categoryDao.delete(id);
//                    return true;
//                })
//                .orElse(false);
//    }
//
//    public Optional<CategoryDto> update(Integer id, CategoryDto categoryDto) {
//        categoryDao.update(id,createdMapper.toEntity(categoryDto, Category.class));
//        return findById(id);
//
//    }
//
//}

