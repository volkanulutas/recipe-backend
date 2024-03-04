package com.vem.recipes.recipes.service;

import com.vem.recipes.recipes.model.entity.IngredientEntity;
import com.vem.recipes.recipes.model.exception.ResourceNotFoundException;

import java.util.List;

public interface IngredientService {
    List<IngredientEntity> getAllIngredientTemplates();

    IngredientEntity createIngredientTemplate(IngredientEntity ingredient);

    IngredientEntity getIngredientTemplateById(Long id) throws ResourceNotFoundException;

    void deleteIngredientTemplateById(Long id) throws ResourceNotFoundException;
}
