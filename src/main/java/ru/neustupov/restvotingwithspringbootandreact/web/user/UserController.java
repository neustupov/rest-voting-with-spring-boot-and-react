package ru.neustupov.restvotingwithspringbootandreact.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neustupov.restvotingwithspringbootandreact.model.AppUser;
import ru.neustupov.restvotingwithspringbootandreact.repository.UserRepository;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(RestController.class);

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    Collection<AppUser> getAllUsers(){
        log.info("Request to get all users");
        return userRepository.findAll();
    }
}
