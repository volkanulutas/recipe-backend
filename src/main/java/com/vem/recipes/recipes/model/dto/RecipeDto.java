package com.vem.recipes.recipes.model.dto;

import com.vem.recipes.recipes.model.entity.IngredientDetailEntity;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class RecipeDto {
    private Long id;

    private String name;

    private Set<IngredientDetailDto> ingredientDetailSet = new HashSet<>();

    private Map<Long, String> definitionMap = new HashMap<>();
}
