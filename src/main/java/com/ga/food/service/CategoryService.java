package com.ga.food.service;

import com.ga.food.exception.InformationExistException;
import com.ga.food.exception.InformationNotFoundException;
import com.ga.food.model.Category;
import com.ga.food.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Category createCategory(Category categoryObject){
        System.out.println("Service Calling createCategory ==> ");

        Category category = categoryRepository.findByName(categoryObject.getName());
        if(category != null) {
            throw new InformationExistException("category with name " + category.getName() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

    public List<Category> getCategories() {
        System.out.println("Service calling getCategories ==>");
        return categoryRepository.findAll();
    }

    public Category getCategory(Long categoryId) {
        System.out.println("service getCategory ==>");

        return categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "category with id " + categoryId + " not found"
                        )
                );
    }

}
