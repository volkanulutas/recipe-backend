package com.vem.recipes.recipes.repository;

import com.vem.recipes.recipes.model.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {}
