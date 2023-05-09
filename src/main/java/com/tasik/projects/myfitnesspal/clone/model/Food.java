package com.tasik.projects.myfitnesspal.clone.model;

public class Food {
    private final int id;
    private String desc;
    private double carb;
    private double fat;
    private double protein;
    private double kcal;

    public Food(int id, String desc, double carb, double fat, double protein) {
        this.id = id;
        this.desc = desc;
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
        calculateKcal();
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getKcal() {
        return kcal;
    }

    public void calculateKcal() {
        this.kcal = (this.protein + this.carb)*4 + this.fat*9;
    }
}
