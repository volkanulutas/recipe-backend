package com.vem.recipes.recipes.converter;

import com.vem.recipes.recipes.model.dto.RecipeDto;
import com.vem.recipes.recipes.model.entity.RecipeEntity;

import java.util.stream.Collectors;

public class RecipeConverter {
    public static RecipeEntity toEntity(RecipeDto source) {
        RecipeEntity target = new RecipeEntity();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setIngredientDetailSet(
                source.getIngredientDetailSet().stream().map(e -> IngredientDetailConverter.toEntity(e)).collect(Collectors.toSet()));
        target.setDefinitionMap(source.getDefinitionMap());
        return target;
    }

    public static RecipeDto toDto(RecipeEntity source) {
        RecipeDto target = new RecipeDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setIngredientDetailSet(
                source.getIngredientDetailSet().stream().map(e -> IngredientDetailConverter.toDto(e)).collect(Collectors.toSet()));
        target.setDefinitionMap(source.getDefinitionMap());
        return target;
    }
}
