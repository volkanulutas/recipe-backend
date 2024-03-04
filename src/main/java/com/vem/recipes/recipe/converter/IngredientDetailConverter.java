package com.vem.recipes.recipe.converter;

import com.vem.recipes.recipe.model.dto.IngredientDetailDto;
import com.vem.recipes.recipe.model.entity.IngredientDetailEntity;

public class IngredientDetailConverter {
    public static IngredientDetailDto toDto(IngredientDetailEntity source) {
        IngredientDetailDto target = new IngredientDetailDto();
        target.setId(source.getId());
        target.setAmount(source.getAmount());
        return target;
    }

    public static IngredientDetailEntity toEntity(IngredientDetailDto source) {
        IngredientDetailEntity target = new IngredientDetailEntity();
        target.setId(source.getId());
        target.setAmount(source.getAmount());
        return target;
    }
}
