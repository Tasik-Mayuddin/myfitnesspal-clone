package com.tasik.projects.myfitnesspal.clone.model;

import jakarta.persistence.*;

@Entity
@Table(name = "food_table")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int fdcId;
    @Column
    private String name;
    @Column
    private double carb;
    @Column
    private double fat;
    @Column
    private double protein;
    @Column
    private double kcal;

    public Food() {

    }

    public Food(int fdcId, String name, double carb, double fat, double protein) {
        this.fdcId = fdcId;
        this.name = name;
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
        calculateKcal();
    }

    public int getFdcId() {
        return fdcId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
