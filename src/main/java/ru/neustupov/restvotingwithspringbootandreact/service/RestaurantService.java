package ru.neustupov.restvotingwithspringbootandreact.service;

import ru.neustupov.restvotingwithspringbootandreact.to.RestaurantWithTodaysMenu;

import java.util.List;

public interface RestaurantService {

    List<RestaurantWithTodaysMenu> getAllRestaurantsWithMealsFromTodaysMenu();
}
