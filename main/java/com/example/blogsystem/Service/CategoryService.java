package com.example.blogsystem.Service;

import com.example.blogsystem.ApiResponse.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Repository.CategoryRepository;
import com.example.blogsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;

    //• Get all the Category
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    //• Add new Category
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    //• Update Category
    public void updateCategory(Integer categoryId,Category category) {
        Category c=categoryRepository.findCategoriesByCategoryId(categoryId);
        if (c == null) {
            throw new ApiException("Wrong id");
        }
        c.setName(category.getName());
        categoryRepository.save(c);
    }

    //• Delete Category
    public void deleteCategory(Integer categoryId) {
        Category c =categoryRepository.findCategoriesByCategoryId(categoryId);
        if (c == null) {
            throw new ApiException("Wrong id");
        }
        categoryRepository.delete(c);

    }

    //• Get All post with specific category endpoint #3
    public List<Category> searchBycategory(String name){
        List<Category>categories =categoryRepository.findCategoriesByName(name);
        if (categories.isEmpty()) {
            throw new ApiException("Category not found");
        }
        return categories;
    }









}
