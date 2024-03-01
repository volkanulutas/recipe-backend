package com.vem.recipes.recipes.model.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends Throwable {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
