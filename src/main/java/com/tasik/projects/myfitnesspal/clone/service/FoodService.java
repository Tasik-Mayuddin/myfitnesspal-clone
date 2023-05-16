package com.tasik.projects.myfitnesspal.clone.service;

import com.tasik.projects.myfitnesspal.clone.model.*;
import com.tasik.projects.myfitnesspal.clone.repository.DiaryRepository;
import com.tasik.projects.myfitnesspal.clone.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    @Autowired
    FoodRepository repo;

    @Autowired
    DiaryRepository diaryRepo;

//    private List<Food> db = new ArrayList<Food>();


    public List<Food> getFoods() {
        return repo.findAll();
    }

    public Food addFood(int fdcId) {
        String uri = "https://api.nal.usda.gov/fdc/v1/food/" + fdcId + "?api_key=pBXvd6dJmtKICUJFccfOtOFx62abhB91gH6q8Gjd&nutrients=203, 204, 205&format=abridged";
        RestTemplate restTemplate = new RestTemplate();
        FoodItem result = restTemplate.getForObject(uri, FoodItem.class);
        return repo.save(foodCreation(result));
    }

    public List<Food> querySearch(String query) {
        String uri = "https://api.nal.usda.gov/fdc/v1/foods/search?api_key=pBXvd6dJmtKICUJFccfOtOFx62abhB91gH6q8Gjd&query=" + query;
        RestTemplate restTemplate = new RestTemplate();
        SearchResult result = restTemplate.getForObject(uri, SearchResult.class);

        List<Food> convertedFood = new ArrayList<Food>();
        for (FoodItem x : result.getFoods()) {
            convertedFood.add(foodCreation(x));
        }
        return convertedFood;
    }

    public Diary showDiary() {
        return diaryRepo.findAll().stream().findFirst().orElse(null);
    }

    public void addToDiary(int fdcId) {
        String uri = "https://api.nal.usda.gov/fdc/v1/food/" + fdcId + "?api_key=pBXvd6dJmtKICUJFccfOtOFx62abhB91gH6q8Gjd&nutrients=203, 204, 205&format=abridged";
        RestTemplate restTemplate = new RestTemplate();
        FoodItem result = restTemplate.getForObject(uri, FoodItem.class);

        Diary diary = diaryRepo.findAll().stream().findFirst().orElse(new Diary());
        diary.addDailyFoods(foodCreation(result));
        diaryRepo.save(diary);
    }

    private Food foodCreation(FoodItem foodItem) {
        double protein = 0;
        double carb = 0;
        double fat = 0;
        for (FoodNutrient y : foodItem.getFoodNutrients()) {
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

        return new Food(foodItem.getFdcId(), foodItem.getDescription(), carb, fat, protein);
    }
}
