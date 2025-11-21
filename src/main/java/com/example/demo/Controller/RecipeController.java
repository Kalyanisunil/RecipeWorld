package com.example.demo.Controller;


import com.example.demo.Models.Recipe;
import com.example.demo.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private RecipeRepository repo;


    @GetMapping("/public")
    List<Recipe> getAllRecipes() {
        return repo.findAll();
    }
}
