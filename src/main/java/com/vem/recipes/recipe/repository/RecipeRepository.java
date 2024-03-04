package com.vem.recipes.recipe.repository;

import com.vem.recipes.recipe.model.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {}
