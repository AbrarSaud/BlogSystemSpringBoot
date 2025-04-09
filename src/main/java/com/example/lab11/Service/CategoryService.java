package com.example.lab11.Service;

import com.example.lab11.Model.Category;
import com.example.lab11.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    //     Get all Category
    public List<Category> getAllUsers() {
        return categoryRepository.findAll();
    }

    //     Add a new Category
    public void addUser(Category user) {
        categoryRepository.save(user);
    }

    //     Update a Category
    public Boolean updateCategory(Integer category_id, Category category) {
        Category oldCategory = categoryRepository.findCategoryById(category_id);
        if (oldCategory == null) {
            return false;
        }

        oldCategory.setName(category.getName());

        categoryRepository.save(oldCategory);
        return true;
    }

    //     Delete a Category
    public Boolean deleteCategory(Integer category_id) {
        Category deleteCategory = categoryRepository.findCategoryById(category_id);
        if (deleteCategory == null) {
            return false;
        }
        categoryRepository.delete(deleteCategory);
        return true;
    }


}
