package ru.neustupov.restvotingwithspringbootandreact.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"menus", "votes"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Restaurant extends AbstractNamedEntity{

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("restaurant")
    private Set<Menu> menus;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Vote> votes;
}
