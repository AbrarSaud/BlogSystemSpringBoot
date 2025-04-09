package com.example.lab11.Repository;


import com.example.lab11.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    //     Endpoint #1
    Category findCategoryById(Integer categoryId);


}
