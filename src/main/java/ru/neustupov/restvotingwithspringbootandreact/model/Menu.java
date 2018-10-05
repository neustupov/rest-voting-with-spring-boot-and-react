package ru.neustupov.restvotingwithspringbootandreact.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"meals"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menu",
        uniqueConstraints = @UniqueConstraint(columnNames = {"date", "restaurant_id"}))
public class Menu extends AbstractEntity {

    @NotNull
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("menus")
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("menu")
    private Set<Meal> meals;
}
