package ru.neustupov.restvotingwithspringbootandreact.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.neustupov.restvotingwithspringbootandreact.model.Role;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

    private Long id;
    private String name;
    private String email;
    private Date registered;
    private boolean enabled = true;
    private String roles;
}
