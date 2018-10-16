package ru.neustupov.restvotingwithspringbootandreact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neustupov.restvotingwithspringbootandreact.model.Menu;
import ru.neustupov.restvotingwithspringbootandreact.model.Restaurant;
import ru.neustupov.restvotingwithspringbootandreact.model.VoteCount;
import ru.neustupov.restvotingwithspringbootandreact.repository.MenuRepository;
import ru.neustupov.restvotingwithspringbootandreact.repository.RestaurantRepository;
import ru.neustupov.restvotingwithspringbootandreact.repository.VoteRepository;
import ru.neustupov.restvotingwithspringbootandreact.to.RestaurantWithTodaysMenu;
import ru.neustupov.restvotingwithspringbootandreact.utils.RestaurantUtil;

import java.util.Collection;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public List<RestaurantWithTodaysMenu> getAllRestaurantsWithMealsFromTodaysMenu() {

        Collection<Restaurant> allRestaurants = restaurantRepository.findAll();

        Collection<Menu> allTodaysMenus = menuRepository.findAllTodaysMenus();

        Collection<VoteCount> voteCounts = voteRepository.getVoteCountForCurrentDate();

        return RestaurantUtil.convertRestaurantToRestaurantTo(allRestaurants, allTodaysMenus, voteCounts);
    }
}
