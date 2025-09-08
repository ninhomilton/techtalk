package com.epam.techtalk.taskmanager.controller;

import com.epam.techtalk.taskmanager.model.Task;
import com.epam.techtalk.taskmanager.service.FeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {

    private final FeignService feignService;



    public FeignController(FeignService feignService) {
        this.feignService = feignService;
    }

    @GetMapping("/external-tasks")
    public List<Task> getExternalTasks() {
        return feignService.fetchTasks();
    }
}
