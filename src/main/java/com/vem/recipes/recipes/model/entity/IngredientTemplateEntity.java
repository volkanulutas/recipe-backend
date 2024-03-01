package com.vem.recipes.recipes.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INGREDIENT_TEMPLATE")
public class IngredientTemplateEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String picture;
}
