package ru.neustupov.restvotingwithspringbootandreact.web.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neustupov.restvotingwithspringbootandreact.service.MenuService;
import ru.neustupov.restvotingwithspringbootandreact.to.MenuWithVotes;

import java.util.Collection;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final Logger log = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private MenuService menuService;

    @GetMapping
    Collection<MenuWithVotes> getTodaysMenu() {
        log.info("Request to get all todays menus with meals");
        return menuService.getAllTodaysMenusWithVotes();
    }
}
