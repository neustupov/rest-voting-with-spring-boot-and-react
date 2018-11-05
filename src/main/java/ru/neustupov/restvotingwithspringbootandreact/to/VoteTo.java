package ru.neustupov.restvotingwithspringbootandreact.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.dom4j.tree.AbstractEntity;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoteTo extends AbstractEntity {

    private Long userId;
    private Date date;
    private Long restId;
}
