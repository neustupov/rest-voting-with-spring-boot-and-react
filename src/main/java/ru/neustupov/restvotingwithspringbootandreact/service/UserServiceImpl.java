package ru.neustupov.restvotingwithspringbootandreact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neustupov.restvotingwithspringbootandreact.exception.ResourceNotFoundException;
import ru.neustupov.restvotingwithspringbootandreact.model.AppUser;
import ru.neustupov.restvotingwithspringbootandreact.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void enable(String name, boolean enabled) {
        AppUser user = userRepository.findByNameOrEmail(name, name)
                .orElseThrow(() -> new ResourceNotFoundException("User", "name", name));
        user.setEnabled(enabled);
        userRepository.save(user);
    }
}
