package com.ga.food.controller;

import com.ga.food.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api")
@AllArgsConstructor
public class RecipeController {

    private RecipeService recipeService;

}
