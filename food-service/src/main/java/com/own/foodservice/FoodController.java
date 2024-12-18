package com.own.foodservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<Food> createFood(@ModelAttribute FoodDTO food) {
        return FoodMapper.mapToFood(food).flatMap(foodService::createFood);
    }

    @PutMapping("/{id}")
    public Mono<Food> updateFood(@PathVariable("id") Long id, @RequestBody FoodDTO food) {
        return FoodMapper.mapToFood(food).flatMap(updFood -> foodService.updateFood(id, updFood));
    }

    @GetMapping("/{id}")
    public Mono<Food> getFoodById(@PathVariable(value = "id") Long id) {
        return foodService.getFood(id);

    }

    @GetMapping("/roll")
    public Mono<Food> rollFood(@RequestParam(value = "difficulty", defaultValue = "EASY", required = false) Difficulty difficulty) {
        return foodService.getFood(difficulty);

    }

    @GetMapping
    public Flux<Food> getAllFoods(
            @RequestParam(defaultValue = "0", value = "page") int page,
            @RequestParam(defaultValue = "10", value = "size") int size,
            FoodFilter filter
    ) {
        return foodService.getFood(page, size);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteFood(@PathVariable("id") Long id) {
        return foodService.removeFood(id);
    }
}
