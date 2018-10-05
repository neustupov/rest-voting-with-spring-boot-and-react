package ru.neustupov.restvotingwithspringbootandreact.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.neustupov.restvotingwithspringbootandreact.model.Meal;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuWithVotes {

    private String nameOfRestaurant;
    private Long idOfRestaurant;
    private Integer numberOfVotes;
    private Set<Meal> meals;

}
