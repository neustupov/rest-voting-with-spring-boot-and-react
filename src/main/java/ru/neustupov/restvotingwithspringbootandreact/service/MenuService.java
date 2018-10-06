package ru.neustupov.restvotingwithspringbootandreact.service;

import ru.neustupov.restvotingwithspringbootandreact.to.MenuWithVotes;

import java.util.List;

public interface MenuService {

    List<MenuWithVotes> getAllTodaysMenusWithVotes();
}
