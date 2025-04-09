package com.example.lab11.Controller;

import com.example.lab11.Api.ApiResponse;
import com.example.lab11.Model.Category;
import com.example.lab11.Model.User;
import com.example.lab11.Service.CategoryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    //     Get all Category
    @GetMapping("/get")
    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllUsers());
    }

    //     Add a new Category
    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        categoryService.addUser(category);
        return ResponseEntity.status(200).body(new ApiResponse("Category added !!"));
    }

    //     Update Category
    @PutMapping("/update/{category_id}")
    public ResponseEntity<?> updateCategory(@PathVariable Integer category_id, @Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate = categoryService.updateCategory(category_id, category);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new ApiResponse("Category Update"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));

    }

    //      Delete Category
    @DeleteMapping("/delete/{category_id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer category_id) {
        Boolean isDelete = categoryService.deleteCategory(category_id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("Category delete"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

}
