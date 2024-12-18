package com.own.foodservice;

import lombok.SneakyThrows;
import org.springframework.core.io.buffer.DataBufferUtils;
import reactor.core.publisher.Mono;

import java.awt.image.DataBuffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class FoodMapper {

    @SneakyThrows
    public static Mono<Food> mapToFood(FoodDTO foodDTO) {
        Food food = new Food();
        food.setName(foodDTO.name());
        food.setDifficulty(foodDTO.difficulty());
        if (foodDTO.image() != null) {
            return DataBufferUtils.join(foodDTO.image().content()) // Собираем весь контент
                    .map(buffer -> {
                        byte[] bytes = new byte[buffer.readableByteCount()];
                        buffer.read(bytes);
                        DataBufferUtils.release(buffer); // Освобождаем буфер
                        return bytes;
                    })
                    .map(bytes -> {
                        food.setImage(bytes); // Устанавливаем байты изображения
                        food.setImageFileExtension(String.valueOf(foodDTO.image().headers().getContentType()));
                        return food;
                    });
        }
        return Mono.just(food);
    }
}
