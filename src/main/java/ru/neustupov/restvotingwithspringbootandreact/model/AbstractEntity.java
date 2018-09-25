package ru.neustupov.restvotingwithspringbootandreact.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue
    private Integer id;
}
