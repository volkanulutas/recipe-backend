package com.vem.recipes.recipes;

import com.vem.recipes.recipes.model.entity.IngredientEntity;
import com.vem.recipes.recipes.model.entity.IngredientTemplateEntity;
import com.vem.recipes.recipes.model.entity.RecipeEntity;
import com.vem.recipes.recipes.service.IngredientService;
import com.vem.recipes.recipes.service.IngredientTemplateService;
import com.vem.recipes.recipes.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
public class ApplicationStartup implements InitializingBean {
    private final RecipeService recipeService;

    private final IngredientService ingredientService;

    private final IngredientTemplateService ingredientTemplateService;

    @Autowired
    public ApplicationStartup(RecipeService recipeService, IngredientService ingredientService, IngredientTemplateService ingredientTemplateService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.ingredientTemplateService = ingredientTemplateService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        IngredientTemplateEntity template1 = new IngredientTemplateEntity();
        template1.setName("Kakao");
        template1.setPicture("Kakao Pic");
        template1 = ingredientTemplateService.createIngredientTemplate(template1);
        IngredientTemplateEntity template2 = new IngredientTemplateEntity();
        template2.setName("Leblebi");
        template2.setPicture("Leblebi Pic");
        template2 = ingredientTemplateService.createIngredientTemplate(template2);
        IngredientTemplateEntity template3 = new IngredientTemplateEntity();
        template3.setName("Tahin");
        template3.setPicture("Tahin Pic");
        template3 = ingredientTemplateService.createIngredientTemplate(template3);
        RecipeEntity recipe = new RecipeEntity();
        recipe.setName("Leblebi Topları");
        recipe.setRecipeDetailSet(
                Set.of("1- Bir su bardağı leblebiyi öğütücü kullanarak öğütünüz.", "2- İçerisine 3 yemek kaşığı tahini karıştırınız.",
                        "3- İçerisine 1 yemek kaşığı kakaoyu ekleyiniz.", "4- Karışımı yoğurunuz.", "5- İstenilen top şeklini veriniz.",
                        "6- 15 dk. buzdolabında beklettikten sonra servis edebilirsiniz."));
        IngredientEntity ingredient1 = new IngredientEntity();
        ingredient1.setIngredientTemplate(template1);
        ingredient1.setAmount("1 Kaşık");
        ingredient1 = ingredientService.createIngredient(ingredient1);
        IngredientEntity ingredient2 = new IngredientEntity();
        ingredient2.setIngredientTemplate(template2);
        ingredient2.setAmount("1 Su Bardağı");
        ingredient2 = ingredientService.createIngredient(ingredient2);
        IngredientEntity ingredient3 = new IngredientEntity();
        ingredient2.setIngredientTemplate(template3);
        ingredient2.setAmount("3 Su Bardağı");
        ingredient3 = ingredientService.createIngredient(ingredient3);
        recipe.setIngredientSet(Set.of(ingredient1, ingredient2, ingredient3));
        recipe = recipeService.createRecipe(recipe);
    }
}
