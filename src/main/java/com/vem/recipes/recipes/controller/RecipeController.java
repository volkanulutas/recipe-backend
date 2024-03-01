package com.vem.recipes.recipes.controller;

import com.vem.recipes.recipes.converter.RecipeConverter;
import com.vem.recipes.recipes.model.dto.RecipeDto;
import com.vem.recipes.recipes.model.entity.RecipeEntity;
import com.vem.recipes.recipes.model.exception.ResourceNotFoundException;
import com.vem.recipes.recipes.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("api/recipe")
@Tag(name = "Recipe", description = "Recipe Controller")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {this.recipeService = recipeService;}

    @GetMapping("/")
    @Operation(summary = "Get all Recipe(s).", description = "Get all recipe(s).")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully returned all recipe(s)."),
            @ApiResponse(responseCode = "404", description = "Recipe is not found.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)})
    public ResponseEntity<List<RecipeDto>> getAllRecipes() {
        try {
            List<RecipeDto> recipeList = new ArrayList<>();
            List<RecipeEntity> allRecipes = recipeService.getAllRecipes();
            for (RecipeEntity recipeEntity : allRecipes) {
                recipeList.add(RecipeConverter.toDto(recipeEntity));
            }
            return ResponseEntity.ok(recipeList);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Create recipe(s).", description = "Create recipe(s).")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "The recipe successfully created."),
            @ApiResponse(responseCode = "404", description = "Updated recipe is not found.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)})
    @PostMapping("/")
    public ResponseEntity<RecipeDto> createRecipe(@RequestBody RecipeDto recipeDto) {
        try {
            RecipeEntity recipe = recipeService.createRecipe(RecipeConverter.toEntity(recipeDto));
            return ResponseEntity.ok(RecipeConverter.toDto(recipe));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get all Recipe(s).", description = "Get all recipe(s).")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully returned all recipe(s)."),
            @ApiResponse(responseCode = "404", description = "Recipe is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)})
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable("id") Long id) {
        try {
            RecipeEntity recipe = recipeService.getRecipeById(id);
            return ResponseEntity.ok(RecipeConverter.toDto(recipe));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete the recipe.", description = "Delete the recipe by id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully deleted."),
            @ApiResponse(responseCode = "404", description = "Recipe is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)})
    public ResponseEntity<RecipeDto> deleteRecipeById(@PathVariable("id") Long id) {
        try {
            recipeService.deleteRecipeById(id);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
