package com.vem.recipes.recipe.controller;

import com.vem.recipes.recipe.converter.IngredientDetailConverter;
import com.vem.recipes.recipe.model.dto.IngredientDetailDto;
import com.vem.recipes.recipe.model.dto.RecipeDto;
import com.vem.recipes.recipe.model.entity.IngredientDetailEntity;
import com.vem.recipes.recipe.model.exception.ResourceNotFoundException;
import com.vem.recipes.recipe.service.IngredientDetailService;
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
@RequestMapping("api/ingredient")
@Tag(name = "Ingredient", description = "Ingredient Controller")
public class IngredientController {
    private final IngredientDetailService ingredientService;

    @Autowired
    public IngredientController(IngredientDetailService ingredientService) {this.ingredientService = ingredientService;}

    @GetMapping("/")
    @Operation(summary = "Get all ingredient(s).", description = "Get all ingredient(s).")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully returned all ingredient(s)."),
            @ApiResponse(responseCode = "404", description = "Ingredient is not found.", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)})
    public ResponseEntity<List<IngredientDetailDto>> getAllIngredients() {
        try {
            List<IngredientDetailDto> ingredientDtoList = new ArrayList<>();
            List<IngredientDetailEntity> allIngredient = ingredientService.getAllIngredients();
            for (IngredientDetailEntity ingredientDto : allIngredient) {
                ingredientDtoList.add(IngredientDetailConverter.toDto(ingredientDto));
            }
            return ResponseEntity.ok(ingredientDtoList);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Create ingredient(s).", description = "Create ingredient(s).")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "The ingredient successfully created."),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)})
    @PostMapping("/")
    public ResponseEntity<IngredientDetailDto> createIngredient(@RequestBody IngredientDetailDto ingredientDto) {
        try {
            IngredientDetailEntity ingredient = ingredientService.createIngredient(IngredientDetailConverter.toEntity(ingredientDto));
            return ResponseEntity.ok(IngredientDetailConverter.toDto(ingredient));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get all ingredient(s).", description = "Get all ingredient(s).")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully returned all ingredient(s)."),
            @ApiResponse(responseCode = "404", description = "Ingredient is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)})
    public ResponseEntity<IngredientDetailDto> getRecipeById(@PathVariable("id") Long id) {
        try {
            IngredientDetailEntity ingredient = ingredientService.getIngredientById(id);
            return ResponseEntity.ok(IngredientDetailConverter.toDto(ingredient));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete the ingredient.", description = "Delete the ingredient by id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully deleted."),
            @ApiResponse(responseCode = "404", description = "Ingredient is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error.", content = @Content)})
    public ResponseEntity<RecipeDto> deleteRecipeById(@PathVariable("id") Long id) {
        try {
            ingredientService.deleteIngredientById(id);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
