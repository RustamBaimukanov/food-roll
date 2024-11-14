package com.own.foodservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<String> createFood(@RequestBody FoodDTO food) {


        // Logic to create a new food item
        foodService.createFood(FoodMapper.mapToFood(food));
        return ResponseEntity.status(HttpStatus.CREATED).body("Food created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFood(@PathVariable("id") Long id, @RequestBody FoodDTO food) {
        // Logic to update food item by ID
        foodService.updateFood(id, FoodMapper.mapToFood(food));
        return ResponseEntity.ok("Food updated successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable("id") Long id) {
        // Logic to get food item by ID
        return id != null ? ResponseEntity.ok(foodService.getFood(id)) : ResponseEntity.ok(foodService.getFood());

    }

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            FoodFilter filter
    ) {
        return ResponseEntity.ok(foodService.getFood(page, size, filter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable("id") Long id) {
        // Logic to delete food item by ID
        foodService.removeFood(id);
        return ResponseEntity.ok("Food deleted successfully");
    }
}
