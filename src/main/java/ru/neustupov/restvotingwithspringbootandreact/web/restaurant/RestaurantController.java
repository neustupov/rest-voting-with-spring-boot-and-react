package ru.neustupov.restvotingwithspringbootandreact.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neustupov.restvotingwithspringbootandreact.model.Restaurant;
import ru.neustupov.restvotingwithspringbootandreact.repository.RestaurantRepository;

import java.util.Collection;

@RestController
public class RestaurantController {

    private final Logger logger = LoggerFactory.getLogger(RestController.class);

    private RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/restaurants")
    Collection<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }
}
