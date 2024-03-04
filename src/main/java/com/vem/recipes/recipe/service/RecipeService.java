package com.vem.recipes.recipe.service;

import com.vem.recipes.recipe.model.entity.RecipeEntity;
import com.vem.recipes.recipe.model.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Set;

public interface RecipeService {
    List<RecipeEntity> getAllRecipes();

    RecipeEntity createRecipe(RecipeEntity recipe, Set<Long> ingredientDetailIdSet);

    RecipeEntity getRecipeById(Long id) throws ResourceNotFoundException;

    void deleteRecipeById(Long id) throws ResourceNotFoundException;
}
