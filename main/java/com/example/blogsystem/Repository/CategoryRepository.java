package com.example.blogsystem.Repository;

import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Category findCategoriesByCategoryId(Integer categoryId);
    List<Category> findCategoriesByName(String name);






}
