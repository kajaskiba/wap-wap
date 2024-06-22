package com.uep.wap.service;

import com.uep.wap.dto.CategoryDTO;
import com.uep.wap.model.Board;
import com.uep.wap.model.Category;
import com.uep.wap.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getCategoryName());

        categoryRepository.save(category);
    }

    public void editCategory(int category_id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(category_id).get();
        category.setName(categoryDTO.getCategoryName());

        categoryRepository.save(category);
    }

    public Iterable<Category> getAllCategories() {return categoryRepository.findAll();}
    public Optional<Category> getCategoryById(int id) {return categoryRepository.findById(id);}
    public void deleteCategoryById(int id) {categoryRepository.deleteById(id);}
    public Category findCategoryByName(String name) {return categoryRepository.findByName(name);}
}
