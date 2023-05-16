package com.tasik.projects.myfitnesspal.clone.web;

import com.tasik.projects.myfitnesspal.clone.model.*;
import com.tasik.projects.myfitnesspal.clone.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class MyFitnessPalController {

    @Autowired
    private FoodService foodService;

//    private List<Food> db = List.of(new Food(696969, "french toast", 1, 2, 3));

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/foods")
    public List<Food> listFoods() {
        return foodService.getFoods();
    }

    @PostMapping("/foods")
    public Food addFood(@RequestParam int fdcId) {
        return foodService.addFood(fdcId);
    }

    @GetMapping("/search")
    public List<Food> querySearch(@RequestParam String query) {
        return foodService.querySearch(query);
    }

    @GetMapping("/diary")
    public Diary showDiary() {
        return foodService.showDiary();
    }

    @PostMapping("/diary")
    public void addToDiary(@RequestParam int fdcId) {
        foodService.addToDiary(fdcId);
    }

}
