package com.example.demo.Controller;


import com.example.demo.Exceptions.RecipeNotFoundException;
import com.example.demo.Models.Recipe;
import com.example.demo.Models.User;
import com.example.demo.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public Recipe getRecipeById(@PathVariable Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }


    @PostMapping("/addRecipe")
    public Recipe addRecipe(@RequestBody Recipe newRecipe) {
        return repo.save(newRecipe);
    }


    @DeleteMapping("/deleterecipe/{id}")
    String deleteRecipe(@PathVariable Integer id){
        if(!repo.existsById(id)){
            throw new RecipeNotFoundException(id);
        }
        repo.deleteById(id);
        return  "Recipe with id "+id+" has been deleted successfully.";
    }

    @GetMapping("/search")
    public List<Recipe> searchProducts(@RequestParam String title) {
        return repo.findAllByTitleContainingIgnoreCase(title);
    }
}

