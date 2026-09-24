package com.ga.food.controller;

import com.ga.food.model.Recipe;
import com.ga.food.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class RecipeController {

    private RecipeService recipeService;

    @PostMapping("/categories/{categoryId}/recipes")
    public Recipe createRecipe(
            @PathVariable(value = "categoryId") Long categoryId,
            @RequestBody Recipe recipeObject
    ){
        System.out.println("Calling createRecipe ==>");
        return recipeService.createRecipe(categoryId, recipeObject);
    }
}
