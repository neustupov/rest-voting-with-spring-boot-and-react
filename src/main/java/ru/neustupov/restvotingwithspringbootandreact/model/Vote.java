package ru.neustupov.restvotingwithspringbootandreact.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vote",
        uniqueConstraints = @UniqueConstraint(columnNames = {"app_user_id", "date"}))
public class Vote extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JsonIgnore
    private AppUser appUser;

    @NotNull
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JsonIgnore
    private Restaurant restaurant;
}
