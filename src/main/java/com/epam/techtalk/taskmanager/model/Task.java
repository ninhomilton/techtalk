package com.epam.techtalk.taskmanager.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    private Long id;

    @JsonProperty("task_title")
    private String title;
    private String description;

    @JsonProperty("due_date")
    private LocalDate dueDate;

    private boolean isCompleted;

    private Author author;

    private String recipeName;

    @JsonProperty("Recipe_Details")
    private String recipeDetails;

    private String status;

    private String priority;

    public Task() {
    }

    // Constructors, Getters, and Setters
    public Task(Long id, String title, String description, LocalDate dueDate, boolean isCompleted, Author author, String recipeName, String recipeDetails, String status, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.author = author;
        this.recipeName = recipeName;
        this.recipeDetails = recipeDetails;
        this.status = status;
        this.priority = priority;
    }

    public Task(long id, String title, String description, LocalDate dueDate, boolean isCompleted, Author author, String status, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.author = author;
        this.status = status;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Author getAuthor() {
        return author;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeDetails() {
        return recipeDetails;
    }

    public void setRecipeDetails(String recipeDetails) {
        this.recipeDetails = recipeDetails;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}