package com.ga.food.controller;

import com.ga.food.model.Recipe;
import com.ga.food.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @GetMapping("/categories/{categoryId}/recipes")
    public List<Recipe> getRecipes(@PathVariable(value = "categoryId") Long categoryId) {
        System.out.println("calling getRecipes ==>");
        return recipeService.getRecipes(categoryId);
    }

    @GetMapping("/categories/{categoryId}/recipes/{recipeId}")
    public Recipe getRecipe(
            @PathVariable(value = "categoryId") Long categoryId, @PathVariable(value = "recipeId") Long recipeId) {
        System.out.println("calling getRecipe ==>");
        return recipeService.getRecipe(categoryId, recipeId);
    }

    @PutMapping("/categories/{categoryId}/recipes/{recipeId}")
    public Recipe updateCategoryRecipe(@PathVariable(value = "categoryId") Long categoryId,
                                       @PathVariable(value = "recipeId") Long recipeId,
                                       @RequestBody Recipe recipeObject) {
        System.out.println("calling getCategoryRecipe ==>");
        return recipeService.updateRecipe(categoryId, recipeId, recipeObject);
    }

    @DeleteMapping("/categories/{categoryId}/recipes/{recipeId}")
    public ResponseEntity<HashMap<String, String>> deleteRecipe(
            @PathVariable(value = "categoryId") Long categoryId, @PathVariable(value = "recipeId") Long recipeId) {
        System.out.println("calling getCategoryRecipe ==>");
        recipeService.deleteRecipe(categoryId, recipeId);
        HashMap<String, String> responseMessage = new HashMap<>();
        responseMessage.put("status", "recipe with id: " + recipeId + " was successfully deleted.");
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }


}
