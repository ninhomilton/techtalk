package com.epam.techtalk.taskmanager.example;

import com.epam.techtalk.taskmanager.model.Author;
import com.epam.techtalk.taskmanager.model.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;

public class SerializationExample {
    public static void main(String[] args) throws Exception {
        // Create a sample Task object
        Task task = new Task(
                1L,
                "Complete Spring Presentation",
                "Prepare slides and demo for the team.",
                LocalDate.of(2023, 12, 1),
                false,
                new Author("John Doe", "john.doe@example.com")
        );

        // Create the ObjectMapper and register the Java Time module
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Required for LocalDate/Time support

        // Serialize using Jackson
        String json = objectMapper.writeValueAsString(task);

        System.out.println("Serialized JSON:");
        System.out.println(json);
    }
}
