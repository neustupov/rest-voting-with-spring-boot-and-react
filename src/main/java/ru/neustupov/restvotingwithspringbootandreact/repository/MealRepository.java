package ru.neustupov.restvotingwithspringbootandreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neustupov.restvotingwithspringbootandreact.model.Meal;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findAll();

}
