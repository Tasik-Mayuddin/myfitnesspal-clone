package com.tasik.projects.myfitnesspal.clone.repository;

import com.tasik.projects.myfitnesspal.clone.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {

}
