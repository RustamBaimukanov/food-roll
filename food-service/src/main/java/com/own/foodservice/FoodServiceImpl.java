package com.own.foodservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

    private final FoodRepository repository;

    @Override
    public Mono<Food> createFood(Food food) {
        return repository.save(food);
    }

    @Override
    @Transactional
    public Mono<Food> updateFood(Long id, Food food) {
        return repository.findById(id)
                .doOnNext(element ->
                        new Food(id, food.getName(), food.getDifficulty(), food.getImage(), food.getImageFileExtension()))
                .flatMap(repository::save);
    }

    /***
     * Get food randomly
     * @return Food
     */
    @Override
    public Mono<Food> getFood(Difficulty difficulty) {

//        return repository.findAllByDifficulty(difficulty).stream()
//                .skip(randomIndex)
//                .findFirst().orElseThrow(() -> new RuntimeException(Constants.TEMP_EXCEPTION));
        return Mono.from(repository.findAllByDifficulty(difficulty).skip(new Random().nextInt(5)));
    }

    @Override
    public Mono<Food> getFood(Long id) {
        //return repository.findById(id).orElseThrow(() -> new RuntimeException(Constants.TEMP_EXCEPTION));
        return repository.findById(id);
    }

    @Override
    public Flux<Food> getFood(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Specification<Food> specification = FoodSpecification.filterByFoodProperties(filter);
//        Page<Food> foods = repository.findAll(specification, pageable);
//        return foods.getContent();
        return repository.findAll()
                .skip(page*size)
                .take(size)
                .map(food -> new Food(food.getId(), food.getName(), food.getDifficulty(), null, null));
    }

    @Override
    public void removeFood(Long id) {
        repository.deleteById(id);
    }
}
