package com.tasik.projects.myfitnesspal.clone.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diary_table")
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "diary_id")
    List<Food> dailyFoods;
    @Column
    double totalProtein;
    @Column
    double totalCarb;
    @Column
    double totalFat;
    @Column
    double totalKcal;

    public Diary() {
        this.dailyFoods = new ArrayList<>();
    }

    public Food addDailyFoods(Food food) {
        dailyFoods.add(food);
        return food;
    }

    public List<Food> getDailyFoods() {
        return dailyFoods;
    }

    public void setDailyFoods(List<Food> dailyFoods) {
        this.dailyFoods = dailyFoods;
    }

    public double getTotalProtein() {
        this.totalProtein = 0;
        dailyFoods.forEach((food) -> this.totalProtein += food.getProtein());
        return totalProtein;
    }

    public void setTotalProtein(double totalProtein) {
        this.totalProtein = totalProtein;
    }

    public double getTotalCarb() {
        this.totalCarb = 0;
        dailyFoods.forEach((food) -> this.totalCarb += food.getCarb());
        return totalCarb;
    }

    public void setTotalCarb(double totalCarb) {
        this.totalCarb = totalCarb;
    }

    public double getTotalFat() {
        this.totalFat = 0;
        dailyFoods.forEach((food) -> this.totalFat += food.getFat());
        return totalFat;
    }

    public void setTotalFat(double totalFat) {
        this.totalFat = totalFat;
    }

    public double getTotalKcal() {
        this.totalKcal = 0;
        dailyFoods.forEach((food) -> this.totalKcal += food.getKcal());
        return totalKcal;
    }

    public void setTotalKcal(double totalKcal) {
        this.totalKcal = totalKcal;
    }
}
