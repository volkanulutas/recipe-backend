package com.vem.recipes.recipes.repository;

import com.vem.recipes.recipes.model.entity.IngredientTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientTemplateRepository extends JpaRepository<IngredientTemplateEntity, Long> {}
