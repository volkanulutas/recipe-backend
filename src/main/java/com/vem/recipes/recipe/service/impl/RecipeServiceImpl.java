package com.vem.recipes.recipe.service.impl;

import com.vem.recipes.recipe.model.entity.IngredientDetailEntity;
import com.vem.recipes.recipe.model.entity.RecipeEntity;
import com.vem.recipes.recipe.model.exception.ResourceNotFoundException;
import com.vem.recipes.recipe.repository.RecipeRepository;
import com.vem.recipes.recipe.service.IngredientDetailService;
import com.vem.recipes.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    private final IngredientDetailService ingredientDetailService;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, IngredientDetailService ingredientDetailService) {
        this.recipeRepository = recipeRepository;
        this.ingredientDetailService = ingredientDetailService;
    }

    @Override
    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public RecipeEntity createRecipe(RecipeEntity recipe, Set<Long> ingredientDetailIdSet) {
        RecipeEntity recipeEntity = recipeRepository.save(recipe);
        Set<IngredientDetailEntity> ingredientDetailEntitySet = new HashSet<>();
        for (Long ingredientDetailId : ingredientDetailIdSet) {
            try {
                IngredientDetailEntity ingredientById = ingredientDetailService.getIngredientById(ingredientDetailId);
                ingredientDetailEntitySet.add(ingredientById);
            } catch (ResourceNotFoundException e) {
                log.error("Error is occurred while finding ingredient detail.");
            }
        }
        recipe.setIngredientDetailSet(ingredientDetailEntitySet);
        recipeEntity = recipeRepository.save(recipe);
        return recipeEntity;
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
