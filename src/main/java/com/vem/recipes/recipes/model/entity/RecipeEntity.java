package com.vem.recipes.recipes.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RECIPE")
public class RecipeEntity extends BaseEntity {
    @Column
    private String name;

    @ManyToMany
   private Set<IngredientEntity> ingredientSet = new HashSet<>();

    @Column
    private Set<String> recipeDetailSet = new HashSet<>();
}
