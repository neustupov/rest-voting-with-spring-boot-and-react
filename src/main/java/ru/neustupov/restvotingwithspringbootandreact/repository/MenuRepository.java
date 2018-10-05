package ru.neustupov.restvotingwithspringbootandreact.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.neustupov.restvotingwithspringbootandreact.model.Menu;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT DISTINCT m FROM Menu m WHERE m.restaurant.id=:restId AND m.date=:currDate")
    List<Menu> findOne(@Param("restId") int restId);

    @EntityGraph(attributePaths = {"meals", "restaurant"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT m FROM Menu m WHERE m.date = current_date")
    List<Menu> findAllTodaysMenusWithRestaurantAndMeals();
}
