package ru.neustupov.restvotingwithspringbootandreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.neustupov.restvotingwithspringbootandreact.model.Role;
import ru.neustupov.restvotingwithspringbootandreact.model.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
