package ru.neustupov.restvotingwithspringbootandreact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
class Meal extends AbstractNamedEntity{

    @NotNull
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;
}
