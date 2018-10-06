package ru.neustupov.restvotingwithspringbootandreact.utils;

import ru.neustupov.restvotingwithspringbootandreact.model.Menu;
import ru.neustupov.restvotingwithspringbootandreact.to.MenuWithVotes;

public class menuUtil {

    public static MenuWithVotes menuToMenuWithVotes(Menu menu, Integer numberOfVotes) {

        return new MenuWithVotes(
                menu.getId(),
                menu.getDate(),
                menu.getRestaurant().getId(),
                menu.getRestaurant().getName(),
                numberOfVotes,
                menu.getMeals());
    }
}
