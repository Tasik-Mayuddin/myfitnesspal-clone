package com.tasik.projects.myfitnesspal.clone.model;


import com.fasterxml.jackson.annotation.JsonAlias;

public class FoodNutrient{

    @JsonAlias({"nutrientName", "name"})
    private String nutrientName;

    @JsonAlias({"value", "amount"})
    private double value;

    public String getNutrientName() {
        return nutrientName;
    }

    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
