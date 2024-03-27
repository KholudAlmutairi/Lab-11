package com.example.blogsystem.Controller;

import com.example.blogsystem.ApiResponse.ApiResponse;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Model.User;
import com.example.blogsystem.Service.CategoryService;
import com.example.blogsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getAllCategory(){

        return ResponseEntity.status(200).body(categoryService.getAllCategory());}


    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);

        }

        categoryService.addCategory(category);
        return ResponseEntity.status(200).body(new ApiResponse("Category Added"));

    }


    @PutMapping("/update/{categoryId}")
    public ResponseEntity updateCategory(@PathVariable Integer categoryId, @RequestBody @Valid Category category , Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();

            return ResponseEntity.status(400).body(message);
        }

        categoryService.updateCategory(categoryId,category);
        return ResponseEntity.status(200).body(new ApiResponse( "Category updated"));
    }


    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity deleteCategory(@PathVariable Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(200).body(new ApiResponse("Category deleted!"));
    }

    //endpoint #3

    @GetMapping("/searchBycategory/{name}")
    public ResponseEntity searchBycategory(@PathVariable String name){
        return ResponseEntity.status(200).body(categoryService.searchBycategory(name));
    }








}
