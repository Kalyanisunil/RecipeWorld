package com.example.demo.Repository;

import com.example.demo.Models.Recipe;
import com.example.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.sound.midi.Receiver;
import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    @Override
    List<Recipe> findAll();


}
