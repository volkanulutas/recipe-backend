package com.vem.recipes.recipes.converter;

import com.vem.recipes.recipes.model.dto.RecipeDto;
import com.vem.recipes.recipes.model.entity.RecipeEntity;

import java.util.ArrayList;
import java.util.HashSet;

public class RecipeConverter {
    public static RecipeEntity toEntity(RecipeDto source) {
        RecipeEntity target = new RecipeEntity();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setRecipeDetailSet(new HashSet<>(source.getRecipeDetailList()));
        target.setIngredientSet(new HashSet<>(source.getIngredientList()));
        return target;
    }

    public static RecipeDto toDto(RecipeEntity source) {
        RecipeDto target = new RecipeDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setRecipeDetailList(new ArrayList<>(source.getRecipeDetailSet()));
        target.setIngredientList(new ArrayList<>(source.getIngredientSet()));
        return target;
    }
}
