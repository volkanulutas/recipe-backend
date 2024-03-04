package com.vem.recipes.recipe.service;

import com.vem.recipes.recipe.model.entity.IngredientEntity;
import com.vem.recipes.recipe.model.exception.ResourceNotFoundException;

import java.util.List;

public interface IngredientService {
    List<IngredientEntity> getAllIngredientTemplates();

    IngredientEntity createIngredientTemplate(IngredientEntity ingredient);

    IngredientEntity getIngredientTemplateById(Long id) throws ResourceNotFoundException;

    void deleteIngredientTemplateById(Long id) throws ResourceNotFoundException;
}
