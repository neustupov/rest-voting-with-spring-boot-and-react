package ru.neustupov.restvotingwithspringbootandreact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote extends AbstractEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private AppUser appUser;

    @NotNull
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Restaurant restaurant;
}
