package com.vem.recipes.recipe.model.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends Throwable {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
