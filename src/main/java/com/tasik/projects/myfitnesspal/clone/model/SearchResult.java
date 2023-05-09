package com.tasik.projects.myfitnesspal.clone.model;

import com.tasik.projects.myfitnesspal.clone.model.FoodItem;

import java.util.List;

public class SearchResult {
    private List<FoodItem> foods;

    public List<FoodItem> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodItem> foods) {
        this.foods = foods;
    }
}

