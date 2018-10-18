package ru.neustupov.restvotingwithspringbootandreact.utils;

import ru.neustupov.restvotingwithspringbootandreact.model.Menu;
import ru.neustupov.restvotingwithspringbootandreact.model.Restaurant;
import ru.neustupov.restvotingwithspringbootandreact.model.VoteCount;
import ru.neustupov.restvotingwithspringbootandreact.to.RestaurantWithTodaysMenu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RestaurantUtil {

    public static List<RestaurantWithTodaysMenu> convertRestaurantToRestaurantTo(Collection<Restaurant> restaurants,
                                                                                 Collection<Menu> menus,
                                                                                 Collection<VoteCount> voteCounts) {

        List<RestaurantWithTodaysMenu> restaurantWithTodaysMenus = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {

            RestaurantWithTodaysMenu restaurantWithMeal = new RestaurantWithTodaysMenu();

            restaurantWithMeal.setId(restaurant.getId());
            restaurantWithMeal.setName(restaurant.getName());

            for (VoteCount voteCount : voteCounts) {
                if (voteCount.getRestId().equals(restaurant.getId())) {
                    restaurantWithMeal.setNumberOfVotes(voteCount.getVoteCount().intValue());
                }
            }

            for (Menu menu : menus) {
                if (restaurant.getId().equals(menu.getRestaurant().getId())) {
                    restaurantWithMeal.setMealsFromTodaysMenu(new ArrayList<>(menu.getMeals()));
                }
            }

            if (restaurantWithMeal.getNumberOfVotes() == null) {
                restaurantWithMeal.setNumberOfVotes(0);
            }

            if(restaurantWithMeal.getMealsFromTodaysMenu() == null) {
                restaurantWithMeal.setMealsFromTodaysMenu(Collections.emptyList());
            }

            restaurantWithTodaysMenus.add(restaurantWithMeal);
        }

        return restaurantWithTodaysMenus;
    }
}
