package com.own.foodservice;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class FoodSpecification {
    public static Specification<Food> filterByFoodProperties(FoodFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("name"), "%" + filter.getName() + "%"));
            }

            if (filter.getDifficulty() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("difficulty"), filter.getDifficulty()));
            }

            return predicate;
        };
    }
}