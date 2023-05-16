package com.tasik.projects.myfitnesspal.clone.repository;

import com.tasik.projects.myfitnesspal.clone.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Integer> {
}
