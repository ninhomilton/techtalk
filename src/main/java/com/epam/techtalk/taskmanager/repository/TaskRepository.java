package com.epam.techtalk.taskmanager.repository;

import com.epam.techtalk.taskmanager.model.Task;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    List<Task> findAll();
    void deleteById(Long id);
}