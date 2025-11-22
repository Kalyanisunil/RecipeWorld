package com.example.demo.Controller;


import com.example.demo.Exceptions.RecipeNotFoundException;
import com.example.demo.Models.Recipe;
import com.example.demo.Models.User;
import com.example.demo.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/recipe/{id}")
    List<Recipe> getRecipesById(@PathVariable Integer id)
    {
        Recipe recipe = repo.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
        return List.of(recipe);
    }



    @PostMapping("addRecipe")
    Recipe newRecipe(@RequestBody Recipe newRecipe) {
        return repo.save(newRecipe);
    }

}
