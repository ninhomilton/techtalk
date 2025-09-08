package com.epam.techtalk.taskmanager.http;

import com.epam.techtalk.taskmanager.model.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "taskClient", url = "https://jsonplaceholder.typicode.com")
public interface TaskFeignClient {
    @GetMapping("/todos")
    List<Task> getTasks();
}
