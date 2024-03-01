package com.vem.recipes.recipes.service;

import com.vem.recipes.recipes.model.entity.IngredientEntity;
import com.vem.recipes.recipes.model.exception.ResourceNotFoundException;

import java.util.List;

public interface IngredientService {
    List<IngredientEntity> getAllIngredients();

    IngredientEntity createIngredient(IngredientEntity ingredient);

    IngredientEntity getIngredientById(Long id) throws ResourceNotFoundException;

    void deleteIngredientById(Long id) throws ResourceNotFoundException;
}
