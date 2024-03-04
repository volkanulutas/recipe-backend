package com.vem.recipes.recipe;

import com.vem.recipes.recipe.model.entity.IngredientDetailEntity;
import com.vem.recipes.recipe.model.entity.IngredientEntity;
import com.vem.recipes.recipe.model.entity.RecipeEntity;
import com.vem.recipes.recipe.service.IngredientDetailService;
import com.vem.recipes.recipe.service.IngredientService;
import com.vem.recipes.recipe.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ApplicationStartup implements InitializingBean {
    private final RecipeService recipeService;

    private final IngredientDetailService ingredientService;

    private final IngredientService ingredientTemplateService;

    @Autowired
    public ApplicationStartup(RecipeService recipeService, IngredientDetailService ingredientService, IngredientService ingredientTemplateService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.ingredientTemplateService = ingredientTemplateService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        IngredientEntity ingredient1 = createIngredient("Leblebi", "Leblebi Pic");
        IngredientEntity ingredient2 = createIngredient("Kakao", "Kakao Pic");
        IngredientEntity ingredient3 = createIngredient("Tahin", "Tahin Pic");
        ingredient1 = ingredientTemplateService.createIngredientTemplate(ingredient2);
        ingredient2 = ingredientTemplateService.createIngredientTemplate(ingredient2);
        ingredient3 = ingredientTemplateService.createIngredientTemplate(ingredient3);
        // ----
        IngredientDetailEntity ingredientDetail1 = createIngredientDetail(ingredient1, "1 Su Bardağı");
        ingredientDetail1 = ingredientService.createIngredient(ingredientDetail1);
        IngredientDetailEntity ingredientDetail2 = createIngredientDetail(ingredient1, "1 Su Bardağı");
        ingredientDetail2 = ingredientService.createIngredient(ingredientDetail2);
        IngredientDetailEntity ingredientDetail3 = createIngredientDetail(ingredient1, "3 Su Bardağı");
        ingredientDetail3 = ingredientService.createIngredient(ingredientDetail3);
        // ----
        RecipeEntity recipe = new RecipeEntity();
        recipe.setName("Leblebi Topları");
        Set<IngredientDetailEntity> ingredientDetailSet = Set.of(ingredientDetail1, ingredientDetail2, ingredientDetail3);
        Set<Long> ingredientDetailIdSet = ingredientDetailSet.stream().map(e -> e.getId()).collect(Collectors.toSet());
        Map<Long, String> definitionMap =
                Map.of(1L, "1- Bir su bardağı leblebiyi öğütücü kullanarak öğütünüz.", 2L, "2- İçerisine 3 yemek kaşığı tahini karıştırınız.", 3L,
                        "3- İçerisine 1 yemek kaşığı kakaoyu ekleyiniz.", 4L, "4- Karışımı yoğurunuz.", 5L, "5- İstenilen top şeklini veriniz", 6L,
                        "6- 15 dk. buzdolabında beklettikten sonra servis edebilirsiniz.");
        recipe.setDefinitionMap(definitionMap);
        recipe = recipeService.createRecipe(recipe, ingredientDetailIdSet);
    }

    private static IngredientDetailEntity createIngredientDetail(IngredientEntity ingredient, String amount) {
        IngredientDetailEntity ingredientDetail1 = new IngredientDetailEntity();
        ingredientDetail1.setIngredient(ingredient);
        ingredientDetail1.setAmount(amount);
        return ingredientDetail1;
    }

    private static IngredientEntity createIngredient(String name, String picture) {
        IngredientEntity ingredient3 = new IngredientEntity();
        ingredient3.setName(name);
        ingredient3.setPicture(picture);
        return ingredient3;
    }
}
