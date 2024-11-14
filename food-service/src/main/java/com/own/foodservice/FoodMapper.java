package com.own.foodservice;

import lombok.SneakyThrows;

public class FoodMapper {

    @SneakyThrows
    public static Food mapToFood(FoodDTO foodDTO) {
        Food food = new Food();
        food.setName(foodDTO.name());
        food.setDifficulty(foodDTO.difficulty());
        if (foodDTO.image() != null) {
            food.setImage(foodDTO.image().getBytes());
            food.setImageFileExtension(foodDTO.image().getContentType());
        }

        return food;
    }
}
