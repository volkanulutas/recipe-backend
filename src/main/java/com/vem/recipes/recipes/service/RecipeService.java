package com.vem.recipes.recipes.service;

import com.vem.recipes.recipes.model.entity.RecipeEntity;
import com.vem.recipes.recipes.model.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Set;

public interface RecipeService {
    List<RecipeEntity> getAllRecipes();

    RecipeEntity createRecipe(RecipeEntity recipe, Set<Long> ingredientDetailIdSet);

    RecipeEntity getRecipeById(Long id) throws ResourceNotFoundException;

    void deleteRecipeById(Long id) throws ResourceNotFoundException;
}
