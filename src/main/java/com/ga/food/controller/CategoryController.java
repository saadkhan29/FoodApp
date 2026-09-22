package com.ga.food.controller;

import com.ga.food.exception.InformationExistException;
import com.ga.food.model.Category;
import com.ga.food.repository.CategoryRepository;
import com.ga.food.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    // CRUD
    // C - Create - HTTP POST - To create a record (category)
    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category categoryObject){
        System.out.println("Calling createCategory ==> ");
        return categoryService.createCategory(categoryObject);
    }


    // R - Read - HTTP GET - To read all records / record by id
    @GetMapping("/categories")
    public List<Category> getCategories() {
        System.out.println("calling getCategories() ==> ");
        return categoryService.getCategories();
    }

    @GetMapping(path = "/categories/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        System.out.println("calling getCategory ==>");
        return categoryService.getCategory(categoryId);
    }

    // U - Update - HTTP PUT - To update a record
    // D -Delete - HTTP DELETE - To remove a record



}
