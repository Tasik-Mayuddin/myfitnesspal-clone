package com.tasik.projects.myfitnesspal.clone.service;

import com.tasik.projects.myfitnesspal.clone.model.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {

    private List<Food> db = new ArrayList<Food>();


    public List<Food> getFoods() {
        return db;
    }
}
