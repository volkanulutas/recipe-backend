package com.vem.recipes.recipes.service.impl;

import com.vem.recipes.recipes.model.entity.IngredientEntity;
import com.vem.recipes.recipes.model.exception.ResourceNotFoundException;
import com.vem.recipes.recipes.repository.IngredientRepository;
import com.vem.recipes.recipes.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<IngredientEntity> getAllIngredientTemplates() {
        return ingredientRepository.findAll();
    }

    @Override
    public IngredientEntity createIngredientTemplate(IngredientEntity ingredientTemplate) {
        return ingredientRepository.save(ingredientTemplate);
    }

    @Override
    public IngredientEntity getIngredientTemplateById(Long id) throws ResourceNotFoundException {
        Optional<IngredientEntity> ingredientTemplateOptional = ingredientRepository.findById(id);
        if (ingredientTemplateOptional.isEmpty()) {
            throw new ResourceNotFoundException("The ingredient template is not found.");
        }
        return ingredientTemplateOptional.get();
    }

    @Override
    public void deleteIngredientTemplateById(Long id) throws ResourceNotFoundException {
        IngredientEntity ingredientTemplate = this.getIngredientTemplateById(id);
        this.ingredientRepository.delete(ingredientTemplate);
    }
}
