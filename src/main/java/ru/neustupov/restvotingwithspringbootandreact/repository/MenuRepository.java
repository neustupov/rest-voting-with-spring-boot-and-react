package ru.neustupov.restvotingwithspringbootandreact.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.neustupov.restvotingwithspringbootandreact.model.Menu;

import java.util.Collection;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @EntityGraph(attributePaths = {"meals"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT m FROM Menu m WHERE m.date = current_date")
    Collection<Menu> findAllTodaysMenus();
}
