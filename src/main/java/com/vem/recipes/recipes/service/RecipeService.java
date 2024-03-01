package com.vem.recipes.recipes.service;

import com.vem.recipes.recipes.model.entity.RecipeEntity;
import com.vem.recipes.recipes.model.exception.ResourceNotFoundException;

import java.util.List;

public interface RecipeService {
    List<RecipeEntity> getAllRecipes();

    RecipeEntity createRecipe(RecipeEntity recipe);

    RecipeEntity getRecipeById(Long id) throws ResourceNotFoundException;

    void deleteRecipeById(Long id) throws ResourceNotFoundException;
}
