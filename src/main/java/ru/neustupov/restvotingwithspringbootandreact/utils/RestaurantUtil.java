package ru.neustupov.restvotingwithspringbootandreact.utils;

import lombok.var;
import ru.neustupov.restvotingwithspringbootandreact.model.Menu;
import ru.neustupov.restvotingwithspringbootandreact.model.Restaurant;
import ru.neustupov.restvotingwithspringbootandreact.model.VoteCount;
import ru.neustupov.restvotingwithspringbootandreact.to.RestaurantWithTodaysMenu;

import java.util.*;
import java.util.stream.Collectors;

public class RestaurantUtil {

    public static List<RestaurantWithTodaysMenu> convertRestaurantToRestaurantTo(Collection<Restaurant> restaurants,
                                                                                 Collection<Menu> menus,
                                                                                 Collection<VoteCount> voteCounts) {

        return restaurants.stream().map(restaurant -> {

            var restaurantWithMeal = new RestaurantWithTodaysMenu();

            restaurantWithMeal.setId(restaurant.getId());
            restaurantWithMeal.setName(restaurant.getName());

            Optional<VoteCount> count = voteCounts
                    .stream()
                    .filter(voteCount -> voteCount.getRestId().equals(restaurant.getId()))
                    .findFirst();

            if (count.isPresent()) {
                restaurantWithMeal.setNumberOfVotes(count.get().getVoteCount().intValue());
            } else {
                restaurantWithMeal.setNumberOfVotes(0);
            }

            Optional<Menu> menu = menus
                    .stream()
                    .filter(menuOne -> menuOne.getRestaurant().getId().equals(restaurant.getId()))
                    .findFirst();

            if (menu.isPresent()) {
                restaurantWithMeal.setMealsFromTodaysMenu(new ArrayList<>(menu.get().getMeals()));
            } else {
                restaurantWithMeal.setMealsFromTodaysMenu(Collections.emptyList());
            }

            return restaurantWithMeal;

        }).collect(Collectors.toList());
    }
}
