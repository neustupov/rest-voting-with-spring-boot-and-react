package ru.neustupov.restvotingwithspringbootandreact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant extends AbstractNamedEntity{

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Menu> menus;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Vote> votes;
}
