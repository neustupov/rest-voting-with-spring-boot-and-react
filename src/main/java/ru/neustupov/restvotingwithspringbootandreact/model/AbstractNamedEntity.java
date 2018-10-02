package ru.neustupov.restvotingwithspringbootandreact.model;

import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@ToString
@MappedSuperclass
class AbstractNamedEntity extends AbstractEntity{

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    AbstractNamedEntity(){}

    AbstractNamedEntity(Long id, String name){
        super(id);
        this.name=name;
    }
}
