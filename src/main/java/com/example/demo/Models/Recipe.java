package com.example.demo.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String title;
	private String ingredients;
	private String steps;
	private String cooking_time;
	private String difficulty;
	private String image;
	
	@CreationTimestamp
	private LocalDateTime datetime;

	@ManyToOne
	@JoinColumn(name = "user_id")  // this creates the foreign key column in DB
	private User user;

	public Recipe(String cooking_time, LocalDateTime datetime, String difficulty, Integer id, String image, String ingredients, String steps, String title, User user) {
		this.cooking_time = cooking_time;
		this.datetime = datetime;
		this.difficulty = difficulty;
		this.id = id;
		this.image = image;
		this.ingredients = ingredients;
		this.steps = steps;
		this.title = title;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Recipe() {
	}

	public String getCooking_time() {
		return cooking_time;
	}

	public void setCooking_time(String cooking_time) {
		this.cooking_time = cooking_time;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<String> getIngredients() {
		if (ingredients == null) return List.of();
		return Arrays.stream(ingredients.split("\n"))
				.map(String::trim)
				.filter(s -> !s.isEmpty())
				.toList();
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Recipe{" +
				"cooking_time='" + cooking_time + '\'' +
				", id=" + id +
				", title='" + title + '\'' +
				", ingredients='" + ingredients + '\'' +
				", steps='" + steps + '\'' +
				", difficulty='" + difficulty + '\'' +
				", image='" + image + '\'' +
				", datetime=" + datetime +
				", user=" + user +
				'}';
	}
}