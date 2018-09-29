package ru.neustupov.restvotingwithspringbootandreact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AppUser extends AbstractNamedEntity{

    @Email
    @Size(max = 100)
    @NotNull
    private String email;

    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @NotNull
    private Date registered = new Date();

    @NotNull
    private boolean enabled = true;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Vote> votes;
}
