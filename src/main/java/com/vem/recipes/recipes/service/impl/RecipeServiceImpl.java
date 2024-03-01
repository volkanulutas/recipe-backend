package com.vem.recipes.recipes.service.impl;

import com.vem.recipes.recipes.model.entity.RecipeEntity;
import com.vem.recipes.recipes.model.exception.ResourceNotFoundException;
import com.vem.recipes.recipes.repository.RecipeRepository;
import com.vem.recipes.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {this.recipeRepository = recipeRepository;}

    @Override
    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public RecipeEntity createRecipe(RecipeEntity recipe) {
        return recipeRepository.save(recipe);

    }

    @Override
    public RecipeEntity getRecipeById(Long id) throws ResourceNotFoundException {
        Optional<RecipeEntity> recipeOptional = recipeRepository.findById(id);
        if (recipeOptional.isEmpty()) {
            throw new ResourceNotFoundException("The recipe is not found.");
        }
        return recipeOptional.get();
    }

    @Override
    public void deleteRecipeById(Long id) throws ResourceNotFoundException {
        RecipeEntity recipe = getRecipeById(id);
        recipeRepository.delete(recipe);
    }
}
