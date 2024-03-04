package com.vem.recipes.recipe.service;

import com.vem.recipes.recipe.model.entity.IngredientDetailEntity;
import com.vem.recipes.recipe.model.exception.ResourceNotFoundException;

import java.util.List;

public interface IngredientDetailService {
    List<IngredientDetailEntity> getAllIngredients();

    IngredientDetailEntity createIngredient(IngredientDetailEntity ingredient);

    IngredientDetailEntity getIngredientById(Long id) throws ResourceNotFoundException;

    void deleteIngredientById(Long id) throws ResourceNotFoundException;
}
