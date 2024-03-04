package com.vem.recipes.recipes.converter;

import com.vem.recipes.recipes.model.dto.IngredientDetailDto;
import com.vem.recipes.recipes.model.entity.IngredientDetailEntity;

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
