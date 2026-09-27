package com.ga.food.service;

import com.ga.food.exception.InformationNotFoundException;
import com.ga.food.model.Category;
import com.ga.food.model.Recipe;
import com.ga.food.repository.CategoryRepository;
import com.ga.food.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Recipe> getRecipes(Long categoryId) {
        System.out.println("service calling getRecipes ==>");
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "Category with id " + categoryId + " not found"));

        return category.getRecipeList();
    }

    public Recipe getRecipe(Long categoryId, Long recipeId) {

        return recipeRepository.findByIdAndCategoryId(recipeId, categoryId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "Recipe with id " + recipeId +
                                        " not found in category " + categoryId));
    }

    public Recipe updateRecipe(Long categoryId, Long recipeId, Recipe updatedRecipe) {

        Recipe recipe = recipeRepository.findByIdAndCategoryId(recipeId, categoryId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "Recipe with id " + recipeId +
                                        " not found in category " + categoryId));

        recipe.setName(updatedRecipe.getName());
        recipe.setIngredients(updatedRecipe.getIngredients());
        recipe.setSteps(updatedRecipe.getSteps());
        recipe.setTime(updatedRecipe.getTime());
        recipe.setPortions(updatedRecipe.getPortions());

        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long categoryId, Long recipeId) {

        Recipe recipe = recipeRepository.findByIdAndCategoryId(recipeId, categoryId)
                .orElseThrow(() ->
                        new InformationNotFoundException(
                                "Recipe with id " + recipeId +
                                        " not found in category " + categoryId));

        recipeRepository.delete(recipe);
    }

}
