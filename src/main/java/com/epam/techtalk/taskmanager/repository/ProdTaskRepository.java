package com.epam.techtalk.taskmanager.repository;

import com.epam.techtalk.taskmanager.TechtalkApplication;
import com.epam.techtalk.taskmanager.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("prod")
public class ProdTaskRepository implements TaskRepository {

    private static final Logger logger = LoggerFactory.getLogger(ProdTaskRepository.class);

    private final List<Task> tasks = new ArrayList<>();


    @Override
    public Task save(Task task) {
            // Simulate saving to a database
        logger.info("Saved task to database: {}", task);
        tasks.add(task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        // Simulate fetching from a database
        logger.info("Fetched all tasks from database");
        return tasks;
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Operation not allowed");
        throw new UnsupportedOperationException("Delete operation is not allowed in production environment");
    }
}
