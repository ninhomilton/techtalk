package com.epam.techtalk.taskmanager.controller;

import com.epam.techtalk.taskmanager.model.Task;
import com.epam.techtalk.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
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
}
