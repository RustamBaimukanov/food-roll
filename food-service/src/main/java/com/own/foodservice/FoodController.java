package com.own.foodservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> createFood(@ModelAttribute  FoodDTO food) {


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
    public ResponseEntity<Food> getFoodById(@PathVariable(value = "id") Long id) {
        // Logic to get food item by ID
        return ResponseEntity.ok(foodService.getFood(id));

    }

    @GetMapping("/roll")
    public ResponseEntity<Food> rollFood(@RequestParam(value = "difficulty", defaultValue = "EASY", required = false) Difficulty difficulty) {
        // Randomly get food
        System.out.println(difficulty);
        return ResponseEntity.ok(foodService.getFood(difficulty));

    }

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods(
            @RequestParam(defaultValue = "0", value = "page") int page,
            @RequestParam(defaultValue = "10", value = "size") int size,
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
