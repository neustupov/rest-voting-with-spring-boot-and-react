package ru.neustupov.restvotingwithspringbootandreact.web.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.neustupov.restvotingwithspringbootandreact.model.Restaurant;
import ru.neustupov.restvotingwithspringbootandreact.repository.RestaurantRepository;

import java.util.Collection;
import java.util.List;

@RestController("/restaurants")
public class RestaurantController {

    private final Logger log = LoggerFactory.getLogger(RestController.class);

    private RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping
    Collection<Restaurant> getRestaurants(){
        log.info("Request to get all restaurants with menus");
        return restaurantRepository.findAllWithMenus();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        log.info("Request to delete restaurant: {}", id);
        restaurantRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
