package com.own.foodservice;

import lombok.SneakyThrows;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class FoodMapper {

    @SneakyThrows
    public static Mono<Food> mapToFood(FoodDTO foodDTO) {
        Food food = new Food();
        food.setName(foodDTO.name());
        food.setDifficulty(foodDTO.difficulty());
        List<String> arr = new ArrayList<>();
        arr.add("!");
        arr.add("#@2");
        arr.stream()

        if (foodDTO.image() != null) {
            return foodDTO.image().content()
                    .reduce(ByteBuffer::put)
                    .map(buffer -> {
                        food.setImage(buffer.array());
                        food.setImageFileExtension(foodDTO.image().headers().getContentType().toString());
                        return food;
                    });
        }

        return Mono.just(food);
    }
}
