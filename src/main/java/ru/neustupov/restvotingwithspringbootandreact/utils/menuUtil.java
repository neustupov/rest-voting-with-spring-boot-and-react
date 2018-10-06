package ru.neustupov.restvotingwithspringbootandreact.utils;

import ru.neustupov.restvotingwithspringbootandreact.model.Meal;
import ru.neustupov.restvotingwithspringbootandreact.model.Menu;
import ru.neustupov.restvotingwithspringbootandreact.to.MenuWithVotes;

import java.util.Set;

public class menuUtil {

    public static MenuWithVotes menuToMenuWithVotes(Menu menu, Integer numberOfVotes) {

        String nameOfRestaurant = menu.getRestaurant().getName();
        Long idOfRestaurant = menu.getRestaurant().getId();
        Set<Meal> meals = menu.getMeals();

        return new MenuWithVotes(nameOfRestaurant, idOfRestaurant, numberOfVotes, meals);
    }
}
