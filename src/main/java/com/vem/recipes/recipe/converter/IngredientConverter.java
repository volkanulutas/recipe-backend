package com.vem.recipes.recipe.converter;

import com.vem.recipes.recipe.model.dto.IngredientDto;
import com.vem.recipes.recipe.model.entity.IngredientEntity;

public class IngredientConverter {
    public static IngredientDto toDto(IngredientEntity source) {
        IngredientDto target = new IngredientDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPicture(source.getPicture());
        return target;
    }

    public static IngredientEntity toEntity(IngredientDto source) {
        IngredientEntity target = new IngredientEntity();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPicture(source.getPicture());
        return target;
    }
}
