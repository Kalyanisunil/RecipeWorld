package com.example.demo.Exceptions;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(Integer id) {
        super("Recipe with ID " + id + " not found");
    }
}
