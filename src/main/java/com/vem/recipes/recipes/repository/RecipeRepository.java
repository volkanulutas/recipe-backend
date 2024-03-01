package com.vem.recipes.recipes.repository;

import com.vem.recipes.recipes.model.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {}
