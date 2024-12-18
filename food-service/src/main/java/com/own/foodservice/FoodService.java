package com.own.foodservice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FoodService {

    Mono<Food> createFood(Food food);

    /***
     *
     * @param id id of updated object
     * @param food food object
     */
    Mono<Food> updateFood(Long id, Food food);

    /***
     * Get food randomly by difficulty level
     * @return Food
     */
    Mono<Food> getFood(Difficulty difficulty);

    Mono<Food> getFood(Long id);

    Flux<Food> getFood(int page, int size);

    Mono<Void> removeFood(Long id);


}
