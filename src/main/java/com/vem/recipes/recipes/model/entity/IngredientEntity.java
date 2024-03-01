package com.vem.recipes.recipes.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "INGREDIENT")
public class IngredientEntity extends BaseEntity {
    @Column
    private String amount;

    @ManyToOne
    @JoinColumn(name = "ingredientTemplate_id", nullable = false)
    private IngredientTemplateEntity ingredientTemplate;

    @ManyToMany(mappedBy = "ingredientSet")
    private Set<RecipeEntity> recipeList = new HashSet<>();
}
