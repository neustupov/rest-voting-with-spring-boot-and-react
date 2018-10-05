package ru.neustupov.restvotingwithspringbootandreact.utils;

import org.springframework.beans.factory.annotation.Autowired;
import ru.neustupov.restvotingwithspringbootandreact.model.Meal;
import ru.neustupov.restvotingwithspringbootandreact.model.Menu;
import ru.neustupov.restvotingwithspringbootandreact.repository.MenuRepository;
import ru.neustupov.restvotingwithspringbootandreact.repository.VoteRepository;
import ru.neustupov.restvotingwithspringbootandreact.to.MenuWithVotes;

import java.util.Set;

public class menuUtil {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private VoteRepository voteRepository;

    public MenuWithVotes menuToMenuWithVotes(Menu menu){

        String nameOfRestaurant = menu.getRestaurant().getName();
        Long idOfRestaurant = menu.getRestaurant().getId();
        Integer numberOfVotes = voteRepository.getAllForCurrentDateAndRestaurant(idOfRestaurant).size();
        Set<Meal> meals = menu.getMeals();

        return new MenuWithVotes(nameOfRestaurant, );
    }
}
