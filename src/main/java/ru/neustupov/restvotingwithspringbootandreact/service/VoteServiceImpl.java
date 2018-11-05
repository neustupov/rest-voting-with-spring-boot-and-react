package ru.neustupov.restvotingwithspringbootandreact.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neustupov.restvotingwithspringbootandreact.model.Vote;
import ru.neustupov.restvotingwithspringbootandreact.repository.RestaurantRepository;
import ru.neustupov.restvotingwithspringbootandreact.repository.UserRepository;
import ru.neustupov.restvotingwithspringbootandreact.repository.VoteRepository;
import ru.neustupov.restvotingwithspringbootandreact.to.VoteTo;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Override
    public Vote get(long id) throws NotFoundException {
        return voteRepository.getOne(id);
    }

    @Override
    public Vote save(VoteTo voteTo) {

        Vote vote = new Vote();
        vote.setRestaurant(restaurantRepository.getOne(voteTo.getRestId()));
        vote.setAppUser(userRepository.getOne(voteTo.getUserId()));
        vote.setDate(voteTo.getDate());

        return voteRepository.save(vote);
    }
}
