package com.example.demo.Repository;

import com.example.demo.Models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.sound.midi.Receiver;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    @Override
    List<Recipe> findAll();
}
