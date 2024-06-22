package com.uep.wap.controller;

import com.uep.wap.dto.BoardDTO;
import com.uep.wap.dto.CategoryDTO;
import com.uep.wap.model.Category;
import com.uep.wap.service.BoardService;
import com.uep.wap.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping(path = "/categories")
    public String addCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.addCategory(categoryDTO);
        return "Category added successfully";
    }

    @PutMapping(path = "/categories/{category_id}")
    public String editCategory(@PathVariable  int category_id ,@RequestBody CategoryDTO categoryDTO) {
        categoryService.editCategory(category_id ,categoryDTO);
        return "Category edited successfully";
    }

    @GetMapping(path = "/categories")
    public Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(path="/categories/{id}")
    public Optional<Category> getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }
    @DeleteMapping(path = "/categories/{id}")
    public String deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return "Category deleted successfully";
    }

    @GetMapping(path="/categories/{name}")
    public Category findCategoryByName(@PathVariable String name) {
        return categoryService.findCategoryByName(name);
    }
}
