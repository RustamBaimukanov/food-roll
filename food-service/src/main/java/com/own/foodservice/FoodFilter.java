package com.own.foodservice;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodFilter {
    private String name;
    private Difficulty difficulty;
}
