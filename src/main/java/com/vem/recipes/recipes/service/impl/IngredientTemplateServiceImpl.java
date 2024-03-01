package com.vem.recipes.recipes.service.impl;

import com.vem.recipes.recipes.model.entity.IngredientTemplateEntity;
import com.vem.recipes.recipes.model.exception.ResourceNotFoundException;
import com.vem.recipes.recipes.repository.IngredientTemplateRepository;
import com.vem.recipes.recipes.service.IngredientTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientTemplateServiceImpl implements IngredientTemplateService {
    private final IngredientTemplateRepository ingredientTemplateRepository;

    @Autowired
    public IngredientTemplateServiceImpl(IngredientTemplateRepository IngredientTemplateRepository) {
        this.ingredientTemplateRepository = IngredientTemplateRepository;
    }

    @Override
    public List<IngredientTemplateEntity> getAllIngredientTemplates() {
        return ingredientTemplateRepository.findAll();
    }

    @Override
    public IngredientTemplateEntity createIngredientTemplate(IngredientTemplateEntity ingredientTemplate) {
        return ingredientTemplateRepository.save(ingredientTemplate);
    }

    @Override
    public IngredientTemplateEntity getIngredientTemplateById(Long id) throws ResourceNotFoundException {
        Optional<IngredientTemplateEntity> ingredientTemplateOptional = ingredientTemplateRepository.findById(id);
        if (ingredientTemplateOptional.isEmpty()) {
            throw new ResourceNotFoundException("The ingredient template is not found.");
        }
        return ingredientTemplateOptional.get();
    }

    @Override
    public void deleteIngredientTemplateById(Long id) throws ResourceNotFoundException {
        IngredientTemplateEntity ingredientTemplate = this.getIngredientTemplateById(id);
        this.ingredientTemplateRepository.delete(ingredientTemplate);
    }
}
