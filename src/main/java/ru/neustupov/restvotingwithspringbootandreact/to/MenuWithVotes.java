package ru.neustupov.restvotingwithspringbootandreact.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.neustupov.restvotingwithspringbootandreact.model.Meal;

import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuWithVotes {

    private Long id;
    private Date date;
    private Long idOfRestaurant;
    private String nameOfRestaurant;
    private Integer numberOfVotes;
    private Set<Meal> meals;

}
