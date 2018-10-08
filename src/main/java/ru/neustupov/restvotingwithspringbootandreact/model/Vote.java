package ru.neustupov.restvotingwithspringbootandreact.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vote",
        uniqueConstraints = @UniqueConstraint(columnNames = {"app_user_id", "date"}))
public class Vote extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private AppUser appUser;

    @NotNull
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JsonIgnoreProperties("votes")
    private Restaurant restaurant;
}
