package com.epam.techtalk.taskmanager.repository;

import com.epam.techtalk.taskmanager.model.Task;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class DevTaskRepository implements TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    @Override
    public Task save(Task task) {
        tasks.remove(task);
        tasks.add(task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public void deleteById(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    @PostConstruct
    public void loadTasksFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            InputStream inputStream = getClass().getResourceAsStream("/data.json");
            if (inputStream != null) {
                List<Task> loadedTasks = objectMapper.readValue(inputStream, new TypeReference<List<Task>>() {});
                tasks.addAll(loadedTasks);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load tasks from JSON file", e);
        }
    }
}
