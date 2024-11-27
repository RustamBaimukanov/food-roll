package com.own.foodservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long>, JpaSpecificationExecutor<Food> {

    List<Food> findAllByDifficulty(Difficulty difficulty);
}
