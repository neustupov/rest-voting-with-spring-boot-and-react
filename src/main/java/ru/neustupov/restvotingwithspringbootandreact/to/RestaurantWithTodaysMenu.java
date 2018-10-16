package ru.neustupov.restvotingwithspringbootandreact.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.neustupov.restvotingwithspringbootandreact.model.Meal;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantWithTodaysMenu {

    private Long id;
    private String name;
    private Integer numberOfVotes;
    private List<Meal> mealsFromTodaysMenu;
}
