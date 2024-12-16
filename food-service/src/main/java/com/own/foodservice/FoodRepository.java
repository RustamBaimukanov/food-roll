package com.own.foodservice;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface FoodRepository extends R2dbcRepository<Food, Long> {

    Flux<Food> findAllByDifficulty(Difficulty difficulty);
}
