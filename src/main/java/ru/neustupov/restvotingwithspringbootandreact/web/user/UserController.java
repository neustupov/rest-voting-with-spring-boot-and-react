package ru.neustupov.restvotingwithspringbootandreact.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.neustupov.restvotingwithspringbootandreact.exception.ResourceNotFoundException;
import ru.neustupov.restvotingwithspringbootandreact.model.AppUser;
import ru.neustupov.restvotingwithspringbootandreact.payload.ApiResponse;
import ru.neustupov.restvotingwithspringbootandreact.payload.UserIdentityAvailability;
import ru.neustupov.restvotingwithspringbootandreact.payload.UserProfile;
import ru.neustupov.restvotingwithspringbootandreact.repository.UserRepository;
import ru.neustupov.restvotingwithspringbootandreact.security.CurrentUser;
import ru.neustupov.restvotingwithspringbootandreact.security.UserPrincipal;
import ru.neustupov.restvotingwithspringbootandreact.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    Collection<UserProfile> getAllUsers() {
        log.info("Request to get all users");

        List<AppUser> appUserList = userRepository.findAll();
        List<UserProfile> userProfileList = new ArrayList<>();

        for (AppUser appUser : appUserList) {
            userProfileList.add(new UserProfile(appUser.getId(), appUser.getName(), appUser.getEmail(),
                    appUser.getRegistered(), appUser.isEnabled(), appUser.getRoles().toString()));
        }

        return userProfileList;
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public UserPrincipal getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return currentUser;
    }

    @GetMapping("/{name}")
    public UserProfile getUserProfile(@PathVariable(value = "name") String name) {
        AppUser appUser = userRepository.findByNameOrEmail(name, name)
                .orElseThrow(() -> new ResourceNotFoundException("User", "name", name));

        return new UserProfile(appUser.getId(), appUser.getName(), appUser.getEmail(), appUser.getRegistered(),
                appUser.isEnabled(), appUser.getRoles().toString());
    }

    @DeleteMapping(value = "/{nameOrEmail}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("nameOrEmail") String nameOrEmail) {
        log.info("Request to delete user : " + nameOrEmail);
        userService.delete(nameOrEmail, nameOrEmail);
    }

    @GetMapping("/checkNameAvailability")
    public UserIdentityAvailability checkNameAvailability(@RequestParam(value = "name") String name) {
        Boolean isAvailable = !userRepository.existsByName(name);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @PostMapping(value = "/{name}")
    public ResponseEntity<?> enable(@PathVariable("name") String name, @RequestParam("enabled") boolean enabled) {
        log.info("Request to enabled/disabled user " + name);

        try {
            userService.enable(name, enabled);
        } catch (Exception e) {
            new ResponseEntity(new ApiResponse(false, "Enabled field is not change!"),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new ApiResponse(true, "Enabled field is change!"),
                HttpStatus.OK);
    }
}
