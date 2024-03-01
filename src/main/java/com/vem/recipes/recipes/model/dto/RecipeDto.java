package com.vem.recipes.recipes.model.dto;

import com.vem.recipes.recipes.model.entity.IngredientEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeDto {
    private Long id;

    private String name;

    private List<IngredientEntity> ingredientList = new ArrayList<>();

    private List<String> recipeDetailList = new ArrayList<>();
}
