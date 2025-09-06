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

    public Task() {}

    // Constructors, Getters, and Setters
    public Task(Long id, String title, String description, LocalDate dueDate, boolean isCompleted, Author author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.author = author;
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
}