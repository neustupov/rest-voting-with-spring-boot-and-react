package ru.neustupov.restvotingwithspringbootandreact.service;

import ru.neustupov.restvotingwithspringbootandreact.to.MenuWithVotes;

import java.util.Collection;

public interface MenuService {

    Collection<MenuWithVotes> getAllTodaysMenusWithVotes();
}
