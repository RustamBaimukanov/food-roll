package com.own.foodservice;

import org.springframework.http.codec.multipart.FilePart;


public record FoodDTO(String name, Difficulty difficulty, FilePart image) {
}
