package com.own.foodservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{

    private final FoodRepository repository;

    @Override
    public void createFood(Food food) {
        repository.save(food);
    }

    @Override
    @Transactional
    public void updateFood(Long id, Food food) {
        Food updatableFood = repository.findById(id).orElseThrow(() -> new RuntimeException(Constants.TEMP_EXCEPTION));
        updatableFood.setName(food.getName());
        updatableFood.setImage(food.getImage());
        updatableFood.setImageFileExtension(food.getImageFileExtension());
        updatableFood.setDifficulty(food.getDifficulty());
    }

    /***
     * Get food randomly
     * @return Food
     */
    @Override
    public Food getFood() {
        long count = repository.count();
        if (count == 0) {
            throw new RuntimeException(Constants.TEMP_EXCEPTION);
        }
        int randomIndex = ThreadLocalRandom.current().nextInt((int) count);
        return repository.findAll().stream()
                .skip(randomIndex)
                .findFirst().orElseThrow(() -> new RuntimeException(Constants.TEMP_EXCEPTION));
    }

    @Override
    public Food getFood(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(Constants.TEMP_EXCEPTION));
    }

    @Override
    public List<Food> getFood(int page, int size, FoodFilter filter) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Food> specification = FoodSpecification.filterByFoodProperties(filter);
        Page<Food> foods = repository.findAll(specification, pageable);
        return foods.getContent();
    }

    @Override
    public void removeFood(Long id) {
        repository.deleteById(id);
    }
}
