package ru.neustupov.restvotingwithspringbootandreact.service;

import javassist.NotFoundException;
import ru.neustupov.restvotingwithspringbootandreact.model.Vote;

public interface VoteService {

    Vote get(long id) throws NotFoundException;

    Vote save(Vote vote);
}
