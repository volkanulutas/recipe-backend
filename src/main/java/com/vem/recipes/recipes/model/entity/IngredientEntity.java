package com.vem.recipes.recipes.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    private String name;

    @Column
    private String picture;

    @OneToMany(mappedBy = "ingredient")
    private Set<IngredientDetailEntity> ingredientDetailSet = new HashSet<>();

    public void addIngredientDetail(IngredientDetailEntity ingredientDetail) {
        ingredientDetailSet.add(ingredientDetail);
        ingredientDetail.setIngredient(this);
    }
}
