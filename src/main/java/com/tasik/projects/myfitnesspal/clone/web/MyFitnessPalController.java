package com.tasik.projects.myfitnesspal.clone.web;

import com.tasik.projects.myfitnesspal.clone.model.Food;
import com.tasik.projects.myfitnesspal.clone.model.FoodItem;
import com.tasik.projects.myfitnesspal.clone.model.FoodNutrient;
import com.tasik.projects.myfitnesspal.clone.model.SearchResult;
import com.tasik.projects.myfitnesspal.clone.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/search")
    public List<Food> querySearch(@RequestParam String query) {
        String uri = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key=pBXvd6dJmtKICUJFccfOtOFx62abhB91gH6q8Gjd&query=" + query;
        System.out.println(uri);
        RestTemplate restTemplate = new RestTemplate();
        SearchResult result = restTemplate.getForObject(uri, SearchResult.class);

        List<Food> convertedFood = new ArrayList<Food>();
        for (FoodItem x : result.getFoods()) {
            double protein = 0;
            double carb = 0;
            double fat = 0;
            for (FoodNutrient y : x.getFoodNutrients()) {
                if (y.getNutrientName().equals("Protein")) {
                    protein = y.getValue();
                }
                else if (y.getNutrientName().equals("Carbohydrate, by difference")) {
                    carb = y.getValue();
                }
                else if (y.getNutrientName().equals("Total lipid (fat)")) {
                    fat = y.getValue();
                }
            }
            convertedFood.add(new Food(x.getFdcId(), x.getDescription(), carb, fat, protein));
        }
        return convertedFood;
    }
}
