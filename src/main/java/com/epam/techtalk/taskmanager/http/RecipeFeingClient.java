package com.epam.techtalk.taskmanager.http;

import com.epam.techtalk.taskmanager.model.Recipe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "recipeClient", url = "https://www.thecocktaildb.com/api/json/v1/1/search.php")
public interface RecipeFeingClient {
    @GetMapping("/search.php")
    Recipe getDrinksByName(@RequestParam("s") String name);
}