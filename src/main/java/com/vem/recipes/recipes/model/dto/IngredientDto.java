package com.vem.recipes.recipes.model.dto;

import lombok.Data;

@Data
public class IngredientDto {
    private Long id;

    private IngredientTemplateDto ingredientTemplate;

    private String amount;
}
