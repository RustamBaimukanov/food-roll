package com.own.foodservice;

import java.util.List;

public interface FoodService {

    void createFood(Food food);

    /***
     *
     * @param id id of updated object
     * @param food food object
     */
    void updateFood(Long id, Food food);

    /***
     * Get food randomly
     * @return Food
     */
    Food getFood();

    Food getFood(Long id);

    List<Food> getFood(int page, int size, FoodFilter filter);

    void removeFood(Long id);


}
