package com.vem.recipes.recipe.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "RECIPE_INGREDIENT_DETAIL_MAPPING", joinColumns = @JoinColumn(name = "recipe_id"),
               inverseJoinColumns = @JoinColumn(name = "ingredient_detail_id"))
    private Set<IngredientDetailEntity> ingredientDetailSet = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "RECIPE_DEFINITION", joinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "recipe_definition")
    private Map<Long, String> definitionMap = new HashMap<>();
}
