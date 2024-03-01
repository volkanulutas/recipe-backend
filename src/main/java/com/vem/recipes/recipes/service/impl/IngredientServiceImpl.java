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
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {this.ingredientRepository = ingredientRepository;}

    @Override
    public List<IngredientEntity> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public IngredientEntity createIngredient(IngredientEntity ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public IngredientEntity getIngredientById(Long id) throws ResourceNotFoundException {
        Optional<IngredientEntity> recipeOptional = ingredientRepository.findById(id);
        if (recipeOptional.isEmpty()) {
            throw new ResourceNotFoundException("The ingredientEntity is not found.");
        }
        return recipeOptional.get();
    }

    @Override
    public void deleteIngredientById(Long id) throws ResourceNotFoundException {
        IngredientEntity ingredient = this.getIngredientById(id);
        this.ingredientRepository.delete(ingredient);
    }
}
