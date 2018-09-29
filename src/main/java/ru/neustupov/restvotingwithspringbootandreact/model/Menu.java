package ru.neustupov.restvotingwithspringbootandreact.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Menu extends AbstractEntity{

    @NotNull
    private Date addDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Meal> meals;
}
