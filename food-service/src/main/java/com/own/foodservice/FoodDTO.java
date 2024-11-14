package com.own.foodservice;

import org.springframework.web.multipart.MultipartFile;

public record FoodDTO(String name, Difficulty difficulty, MultipartFile image) {
}
