package ru.neustupov.restvotingwithspringbootandreact.model;

import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@MappedSuperclass
class AbstractNamedEntity extends AbstractEntity{

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;
}
