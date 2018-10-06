package ru.neustupov.restvotingwithspringbootandreact.service;

import ru.neustupov.restvotingwithspringbootandreact.to.MenuWithVotes;

import java.util.Collection;
import java.util.List;

public interface MenuService {

    Collection<MenuWithVotes> getAllTodaysMenusWithVotes();
}
