package com.epam.techtalk.taskmanager.service;

import com.epam.techtalk.taskmanager.http.TaskFeignClient;
import com.epam.techtalk.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeignService {

    private final TaskFeignClient taskFeignClient;

    public FeignService(TaskFeignClient taskFeignClient) {
        this.taskFeignClient = taskFeignClient;
    }
    public List<Task> fetchTasks() {
        return taskFeignClient.getTasks();
    }
}
