package ru.neustupov.restvotingwithspringbootandreact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Role extends AbstractEntity{

    @Enumerated(EnumType.STRING)
    private RoleName name;
}
