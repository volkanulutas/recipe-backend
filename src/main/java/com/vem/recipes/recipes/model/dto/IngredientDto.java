package com.vem.recipes.recipes.model.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class IngredientDto {
    private Long id;

    private String name;

    private String picture;

    private Set<IngredientDetailDto> ingredientDetailSet = new HashSet<>();

    public void addIngredientDetail(IngredientDetailDto ingredientDetail) {
        ingredientDetailSet.add(ingredientDetail);
    }
}
