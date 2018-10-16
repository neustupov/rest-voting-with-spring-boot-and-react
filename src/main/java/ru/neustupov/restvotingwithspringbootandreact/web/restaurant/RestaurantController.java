package ru.neustupov.restvotingwithspringbootandreact.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.neustupov.restvotingwithspringbootandreact.model.Restaurant;
import ru.neustupov.restvotingwithspringbootandreact.repository.RestaurantRepository;
import ru.neustupov.restvotingwithspringbootandreact.service.RestaurantService;
import ru.neustupov.restvotingwithspringbootandreact.to.RestaurantWithTodaysMenu;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final Logger log = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantService restaurantService;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping
    Collection<RestaurantWithTodaysMenu> getRestaurants(){
        log.info("Request to get all restaurants with meals");
        return restaurantService.getAllRestaurantsWithMealsFromTodaysMenu();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete restaurant: {}", id);
        restaurantRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
