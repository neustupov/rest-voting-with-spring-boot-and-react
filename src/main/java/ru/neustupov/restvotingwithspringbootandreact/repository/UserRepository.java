package ru.neustupov.restvotingwithspringbootandreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neustupov.restvotingwithspringbootandreact.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    List<AppUser> findAll();

    Optional<AppUser> findByNameOrEmail(String name, String email);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);
}
