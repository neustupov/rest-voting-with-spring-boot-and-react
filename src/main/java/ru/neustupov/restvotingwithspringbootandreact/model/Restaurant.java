package ru.neustupov.restvotingwithspringbootandreact.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Restaurant extends AbstractNamedEntity{

    @OneToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Menu> menus;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Vote> votes;
}
