package com.tasik.projects.myfitnesspal.clone.model;

import java.util.ArrayList;
import java.util.List;

public class FoodItem {
    private int fdcId;
    private String description;
    private List<FoodNutrient> foodNutrients;

    public int getFdcId() {
        return fdcId;
    }

    public void setFdcId(int fdcId) {
        this.fdcId = fdcId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FoodNutrient> getFoodNutrients() {
        List<FoodNutrient> filteredList = new ArrayList<FoodNutrient>();
        for (FoodNutrient x : foodNutrients) {
            if (x.getNutrientName().equals("Protein") || x.getNutrientName().equals("Carbohydrate, by difference") || x.getNutrientName().equals("Total lipid (fat)")) {
                filteredList.add(x);
            }
        }
        return filteredList;
    }

    public void setFoodNutrients(List<FoodNutrient> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }
}

