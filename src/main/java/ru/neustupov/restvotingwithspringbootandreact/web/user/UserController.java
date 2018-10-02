package ru.neustupov.restvotingwithspringbootandreact.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neustupov.restvotingwithspringbootandreact.model.AppUser;
import ru.neustupov.restvotingwithspringbootandreact.repository.UserRepository;
import ru.neustupov.restvotingwithspringbootandreact.security.CurrentUser;
import ru.neustupov.restvotingwithspringbootandreact.security.UserPrincipal;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public AppUser getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return new AppUser(currentUser.getId(), currentUser.getName());
    }

    @GetMapping
    Collection<AppUser> getAllUsers(){
        log.info("Request to get all users");
        return userRepository.findAll();
    }
}
