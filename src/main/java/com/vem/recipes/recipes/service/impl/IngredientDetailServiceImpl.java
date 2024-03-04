package com.vem.recipes.recipes.service.impl;

import com.vem.recipes.recipes.model.entity.IngredientDetailEntity;
import com.vem.recipes.recipes.model.exception.ResourceNotFoundException;
import com.vem.recipes.recipes.repository.IngredientDetailRepository;
import com.vem.recipes.recipes.service.IngredientDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientDetailServiceImpl implements IngredientDetailService {
    private final IngredientDetailRepository ingredientDetailRepository;

    @Autowired
    public IngredientDetailServiceImpl(IngredientDetailRepository ingredientRepository) {this.ingredientDetailRepository = ingredientRepository;}

    @Override
    public List<IngredientDetailEntity> getAllIngredients() {
        return ingredientDetailRepository.findAll();
    }

    @Override
    public IngredientDetailEntity createIngredient(IngredientDetailEntity ingredient) {
        return ingredientDetailRepository.save(ingredient);
    }

    @Override
    public IngredientDetailEntity getIngredientById(Long id) throws ResourceNotFoundException {
        Optional<IngredientDetailEntity> recipeOptional = ingredientDetailRepository.findById(id);
        if (recipeOptional.isEmpty()) {
            throw new ResourceNotFoundException("The ingredientEntity is not found.");
        }
        return recipeOptional.get();
    }

    @Override
    public void deleteIngredientById(Long id) throws ResourceNotFoundException {
        IngredientDetailEntity ingredient = this.getIngredientById(id);
        this.ingredientDetailRepository.delete(ingredient);
    }
}
