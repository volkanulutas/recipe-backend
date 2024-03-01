package com.vem.recipes.recipes.converter;

import com.vem.recipes.recipes.model.dto.IngredientTemplateDto;
import com.vem.recipes.recipes.model.entity.IngredientTemplateEntity;

public class IngredientTemplateConverter {
    public static IngredientTemplateDto toDto(IngredientTemplateEntity source) {
        IngredientTemplateDto target = new IngredientTemplateDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPicture(source.getPicture());
        return target;
    }

    public static IngredientTemplateEntity toEntity(IngredientTemplateDto source) {
        IngredientTemplateEntity target = new IngredientTemplateEntity();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setPicture(source.getPicture());
        return target;
    }
}
