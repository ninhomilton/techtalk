package com.epam.techtalk.taskmanager.service;

import com.epam.techtalk.taskmanager.http.RecipeFeingClient;
import com.epam.techtalk.taskmanager.model.Task;
import com.epam.techtalk.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final RecipeFeingClient recipeClient;

    @Autowired
    public TaskService(TaskRepository taskRepository, RecipeFeingClient recipeClient){
        this.taskRepository = taskRepository;
        this.recipeClient = recipeClient;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }



    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task findTaskById(Long id) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> obtainRecipes() {
        return taskRepository
                .findAll()
                .stream()
                .filter(task-> task.getRecipeName()!=null && !task.getRecipeName().isEmpty())
                .map(this::enrichTaskWithRecipe)
                .collect(Collectors.toList());
    }

    private Task enrichTaskWithRecipe(Task task) {
        if (task.getRecipeName() != null && !task.getRecipeName().isEmpty()) {
            task.setRecipeDetails(recipeClient.getDrinksByName(task.getRecipeName()).getFirstDrinkInstructions());
        }
        return task;
    }
}
