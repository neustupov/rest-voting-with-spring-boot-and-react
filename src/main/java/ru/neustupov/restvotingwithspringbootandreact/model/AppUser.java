package ru.neustupov.restvotingwithspringbootandreact.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@Entity
@Table(name = "app_user",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class AppUser extends AbstractNamedEntity {

    @Email
    @Size(max = 100)
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @NotNull
    private Date registered = new Date();

    @NotNull
    private boolean enabled = true;

    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("appUser")
    private Set<Vote> votes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public AppUser() {
    }

    public AppUser(Long id, String name){
        super(id, name);
    }

    public AppUser(String name, String email, String password) {
        super(name);
        this.email = email;
        this.password = password;
    }
}
