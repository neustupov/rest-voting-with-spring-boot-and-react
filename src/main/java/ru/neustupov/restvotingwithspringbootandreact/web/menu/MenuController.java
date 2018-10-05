package ru.neustupov.restvotingwithspringbootandreact.web.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neustupov.restvotingwithspringbootandreact.model.Menu;
import ru.neustupov.restvotingwithspringbootandreact.repository.MenuRepository;

import java.util.Collection;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final Logger log = LoggerFactory.getLogger(RestController.class);

    private MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping
    Collection<Menu> getTodaysMenu(){
        log.info("Request to get all todays menus with meals");
        return menuRepository.findAllTodaysMenusWithRestaurantAndMeals();
    }
}
