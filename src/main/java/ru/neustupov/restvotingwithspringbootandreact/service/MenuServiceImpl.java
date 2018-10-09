package ru.neustupov.restvotingwithspringbootandreact.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neustupov.restvotingwithspringbootandreact.model.Menu;
import ru.neustupov.restvotingwithspringbootandreact.model.VoteCount;
import ru.neustupov.restvotingwithspringbootandreact.repository.MenuRepository;
import ru.neustupov.restvotingwithspringbootandreact.repository.VoteRepository;
import ru.neustupov.restvotingwithspringbootandreact.to.MenuWithVotes;

import java.util.ArrayList;
import java.util.Collection;

import static ru.neustupov.restvotingwithspringbootandreact.utils.menuUtil.menuToMenuWithVotes;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Collection<MenuWithVotes> getAllTodaysMenusWithVotes() {

        Collection<Menu> menus = menuRepository.findAllTodaysMenus();
        Collection<VoteCount> voteCounts = voteRepository.getVoteCountForCurrentDate();

        Collection<MenuWithVotes> menusWithVotes = new ArrayList<>();

        for (Menu menu : menus) {

            int countOfVotes = 0;

            for (VoteCount voteCount : voteCounts){
                if (voteCount.getRestId().equals(menu.getRestaurant().getId())){
                    countOfVotes = voteCount.getVoteCount().intValue();
                }
            }

            menusWithVotes.add(menuToMenuWithVotes(menu, countOfVotes));
        }

        return menusWithVotes;
    }
}
