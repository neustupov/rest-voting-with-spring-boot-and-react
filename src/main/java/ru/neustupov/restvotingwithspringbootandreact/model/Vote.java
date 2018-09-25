package ru.neustupov.restvotingwithspringbootandreact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "votes")
public class Vote {

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private User user;

    @NotNull
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Restaurant restaurant;
}
