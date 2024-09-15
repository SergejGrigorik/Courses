package com.kciray.repository.impl;


import com.kciray.model.menu.Category;
import com.kciray.repository.impl.config.ConfigurationTest;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CategoryRepositoryImplTest extends ConfigurationTest {
    @Autowired
    CategoryRepositoryImpl categoryRepository;

    private Integer id = 1;

    @Test
    void exceptionIfDeleteCategory() {
        assertThrows(Throwable.class, () -> categoryRepository.delete(id));
    }

    @Transactional
    @Test
    void deleteCategoryWithoutReferences() {
        Category save = categoryRepository.save(createCategory("soup"));
        Optional<Category> category = categoryRepository.findById(save.getId());
        assertThat(category.isPresent()).isTrue();
        categoryRepository.delete(save.getId());
        Optional<Category> category2 = categoryRepository.findById(save.getId());
        assertThat(category2.isPresent()).isFalse();
    }

    @Test
    void findCategoryWithDish() {
        try {
            Optional<Category> category = categoryRepository.findCategoryWithDishById(id);
            assertThat(category.isPresent()).isTrue();
            assertThat(category.get().getId()).isEqualTo(id);
            category.get().getDishes();
            assertThat(true).isTrue();
        }catch (Exception e) {
            assertThat(true).isFalse();;
        }
    }

    @Transactional
    @Test
    void update() {
        Optional<Category> byId = categoryRepository.findById(1);
        assertThat(byId).isPresent();
        Category category = byId.get();
        category.setName("soup");
        categoryRepository.update(category);
        assertThat(categoryRepository.findById(id).get().getName()).isEqualTo("soup");
    }

    @Test
    void findById() {
        Optional<Category> found = categoryRepository.findById(id);
        Assertions.assertTrue(found.isPresent());
        Assertions.assertEquals(id, found.get().getId());
    }

    @Test
    void findAll() {
        int id1 = 1;
        int id2 = 2;
        int id3 = 3;
        List<Category> all = categoryRepository.findAll();
        assertThat(all).hasSize(3);
        List<Integer> AllId = all.stream()
                .map(Category::getId)
                .toList();
        assertThat(AllId).contains(id1, id2, id3);
    }

    @Transactional
    @Test
    void save() {
        Category category = createCategory("cheeses");
        Category actual = categoryRepository.save(category);
        Assertions.assertNotNull(actual.getId());
    }


    public Category createCategory(String nameCategory) {
        return Category.builder()
                .name(nameCategory)
                .build();
    }
}