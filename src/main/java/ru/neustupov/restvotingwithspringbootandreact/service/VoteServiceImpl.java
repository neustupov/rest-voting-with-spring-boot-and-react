package ru.neustupov.restvotingwithspringbootandreact.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neustupov.restvotingwithspringbootandreact.model.Vote;
import ru.neustupov.restvotingwithspringbootandreact.repository.RestaurantRepository;
import ru.neustupov.restvotingwithspringbootandreact.repository.UserRepository;
import ru.neustupov.restvotingwithspringbootandreact.repository.VoteRepository;

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
    public Vote save(Vote vote) {

        try {
            if(get(vote.getId()) != null)

            return voteRepository.save(vote);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
