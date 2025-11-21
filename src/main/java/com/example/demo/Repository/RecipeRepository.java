package com.example.demo.Repository;

import com.example.demo.Models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository {
    @Override
    List<Recipe> findAll();
}
