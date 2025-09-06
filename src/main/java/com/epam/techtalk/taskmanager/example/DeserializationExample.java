package com.epam.techtalk.taskmanager.example;

import com.epam.techtalk.taskmanager.model.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class DeserializationExample {

    private static final Logger logger = LoggerFactory.getLogger(DeserializationExample.class);

    public static void main(String[] args) throws Exception {
        // Input JSON
        String json = """
        {
          "id": 1,
          "task_title": "Complete Spring Presentation",
          "description": "Prepare slides and demo for the team.",
          "due_date": "2023-12-01",
          "author": {
            "name": "John Doe",
            "email": "john.doe@example.com"
          }
        }
        """;

        // Deserialize using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Task task = objectMapper.readValue(json, Task.class);

        System.out.println("Deserialized Task:");
        System.out.println("ID: " + task.getId());
        System.out.println("Title: " + task.getTitle());
        System.out.println("Due Date: " + task.getDueDate());
        System.out.println("Author Name: " + task.getAuthor().getName());
    }
}
