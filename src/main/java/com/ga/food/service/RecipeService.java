package com.ga.food.service;

import com.ga.food.exception.InformationNotFoundException;
import com.ga.food.model.Category;
import com.ga.food.model.Recipe;
import com.ga.food.repository.CategoryRepository;
import com.ga.food.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecipeService {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;

    public Recipe createRecipe(Long categoryId, Recipe recipe){
        System.out.println("Service calling createRecipe ==>");
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "Category with id " + categoryId + " not found"
                        ));
        recipe.setCategory(category);
        return recipeRepository.save(recipe);
    }
}
