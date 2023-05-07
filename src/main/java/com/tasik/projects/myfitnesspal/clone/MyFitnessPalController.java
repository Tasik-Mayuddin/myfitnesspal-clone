package com.tasik.projects.myfitnesspal.clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class MyFitnessPalController {

//    private Map<UUID, Food> db = new HashMap<>() {{
//        put(UUID.fromString("6f5352f2-ec08-11ed-a05b-0242ac120003"), new Food(UUID.fromString("6f5352f2-ec08-11ed-a05b-0242ac120003"), 1, 2, 3));
//    }};
    private List<Food> db = List.of(new Food(696969, "french toast", 1, 2, 3));

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/foods")
    public List<Food> listFoods() {
        return db;
    }

    @GetMapping("/search")
    public List<Food> querySearch() {
        String uri = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key=pBXvd6dJmtKICUJFccfOtOFx62abhB91gH6q8Gjd&query=Cheddar%20Cheese";
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
