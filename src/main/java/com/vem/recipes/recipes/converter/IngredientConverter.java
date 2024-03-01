package com.vem.recipes.recipes.converter;

import com.vem.recipes.recipes.model.dto.IngredientDto;
import com.vem.recipes.recipes.model.entity.IngredientEntity;

public class IngredientConverter {
    public static IngredientDto toDto(IngredientEntity source) {
        IngredientDto target = new IngredientDto();
        target.setId(source.getId());
        target.setIngredientTemplate(IngredientTemplateConverter.toDto(source.getIngredientTemplate()));
        target.setAmount(source.getAmount());
        return target;
    }

    public static IngredientEntity toEntity(IngredientDto source) {
        IngredientEntity target = new IngredientEntity();
        target.setId(source.getId());
        target.setIngredientTemplate(IngredientTemplateConverter.toEntity(source.getIngredientTemplate()));
        target.setAmount(source.getAmount());
        return target;
    }
}
