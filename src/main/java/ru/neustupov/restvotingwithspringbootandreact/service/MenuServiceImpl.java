package ru.neustupov.restvotingwithspringbootandreact.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neustupov.restvotingwithspringbootandreact.model.Menu;
import ru.neustupov.restvotingwithspringbootandreact.repository.MenuRepository;
import ru.neustupov.restvotingwithspringbootandreact.repository.VoteRepository;
import ru.neustupov.restvotingwithspringbootandreact.to.MenuWithVotes;

import java.util.ArrayList;
import java.util.List;

import static ru.neustupov.restvotingwithspringbootandreact.utils.menuUtil.menuToMenuWithVotes;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public List<MenuWithVotes> getAllTodaysMenusWithVotes() {

        List<Menu> menus = menuRepository.findAllTodaysMenusWithRestaurantAndMeals();
        List<MenuWithVotes> menusWithVotes = new ArrayList<>();

        for (Menu menu : menus) {
            Integer countOfVotes = voteRepository.getAllForCurrentDateAndRestaurant(menu.getRestaurant().getId())
                    .size();
            menusWithVotes.add(menuToMenuWithVotes(menu, countOfVotes));
        }

        return menusWithVotes;
    }
}
