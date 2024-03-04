package com.vem.recipes.recipe.repository;

import com.vem.recipes.recipe.model.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {}
