package com.vem.recipes.recipes.converter;

import com.vem.recipes.recipes.model.dto.IngredientDto;
import com.vem.recipes.recipes.model.entity.IngredientEntity;

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
