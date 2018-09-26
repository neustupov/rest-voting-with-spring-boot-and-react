package ru.neustupov.restvotingwithspringbootandreact.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@MappedSuperclass
class AbstractEntity {

    @Id
    @GeneratedValue
    private Integer id;
}
