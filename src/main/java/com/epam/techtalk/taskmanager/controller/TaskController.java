package com.epam.techtalk.taskmanager.controller;

import com.epam.techtalk.taskmanager.http.RecipeFeingClient;
import com.epam.techtalk.taskmanager.model.Recipe;
import com.epam.techtalk.taskmanager.model.Task;
import com.epam.techtalk.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final RecipeFeingClient recipeFeingClient;

    @Autowired
    public TaskController(TaskService taskService, RecipeFeingClient recipeFeingClient) {
        this.taskService = taskService;
        this.recipeFeingClient = recipeFeingClient;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTaskCompletion(@PathVariable Long id, @RequestParam boolean completed) {
        Task task = taskService.findTaskById(id);
        task.setCompleted(completed);
        return taskService.save(task);
    }

    @GetMapping("/recipe")
    public Recipe getRecipe(String name) {
        return recipeFeingClient.getDrinksByName(name);
    }
}
