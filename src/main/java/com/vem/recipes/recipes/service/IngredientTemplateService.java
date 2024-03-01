package com.vem.recipes.recipes.service;

import com.vem.recipes.recipes.model.entity.IngredientTemplateEntity;
import com.vem.recipes.recipes.model.exception.ResourceNotFoundException;

import java.util.List;

public interface IngredientTemplateService {
    List<IngredientTemplateEntity> getAllIngredientTemplates();

    IngredientTemplateEntity createIngredientTemplate(IngredientTemplateEntity ingredient);

    IngredientTemplateEntity getIngredientTemplateById(Long id) throws ResourceNotFoundException;

    void deleteIngredientTemplateById(Long id) throws ResourceNotFoundException;
}
