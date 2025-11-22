package com.example.demo.Repository;

import com.example.demo.Models.Recipe;
import com.example.demo.Models.User;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.sound.midi.Receiver;
import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    @Override
    List<Recipe> findAll();


    List<Recipe> findAllByTitle(String title);

    List<Recipe> findAllByTitleContainingIgnoreCase(String title);
}
